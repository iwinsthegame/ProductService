package com.productservice.productservice.thirdPartyClients.fakeStoreClient;

import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDTO;
import com.productservice.productservice.exception.ProductNotFoundException;
import com.productservice.productservice.services.FakeStoreProductService;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class FakeStoreClient {
    private static final Logger logger = LoggerFactory.getLogger(FakeStoreProductService.class);
    private RestTemplateBuilder restTemplateBuilder;
    private String fakeStoreUrl;
    private String pathForProducts;
    private String specificProductUrl;
    private String genericProducturl;


    // private String specificProductUrl = fakeStoreUrl + pathForProducts + "/{id}";
    //As this is not working throwing some error , so we find the solution of using @postConstruct
    // Add Dependency for javax.annotation
//    <dependency>
//    <groupId>javax.annotation</groupId>
//    <artifactId>javax.annotation-api</artifactId>
//    <version>1.3.2</version>
//</dependency>


    //other way around we can do it by intializing inside constructor , lest do it

//    @PostConstruct
//    public void init() {
//         specificProductUrl = fakeStoreUrl + pathForProducts + "/{id}";
//    }
   // private String specificProductUrl = fakeStoreUrl + pathForProducts + "/{id}";
   // private String specificProductUrl = "https://fakestoreapi.com/products/{id}";
  //  private String genericProducturl = "https://fakestoreapi.com/products";

    FakeStoreClient(RestTemplateBuilder restTemplateBuilder,@Value("${fakestore.api.url}") String fakeStoreUrl, @Value("${fakestore.api.paths.products}") String pathForProducts) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.specificProductUrl = fakeStoreUrl + pathForProducts + "/{id}";
        this.genericProducturl = fakeStoreUrl + pathForProducts;
    }

    public FakeStoreProductDto getProductById(Long id) throws ProductNotFoundException {
        //here we are integrating fake stor product api
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.getForEntity(specificProductUrl, FakeStoreProductDto.class, id);
        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();
        if (fakeStoreProductDto == null) {
            //throw an exception
            throw new ProductNotFoundException("Product with id " + id + " doesn't exist.");
        }
        //convert fakstoreproductDTO to genericproduct DTO before returning

        return fakeStoreProductDto;
    }



    public List<FakeStoreProductDto> getAllProducts() {
        List<FakeStoreProductDto> resultList = new ArrayList<>();
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> responseEntityAllProduct = restTemplate.getForEntity(genericProducturl, FakeStoreProductDto[].class);
        List<FakeStoreProductDto> productList = List.of(responseEntityAllProduct.getBody());
        //FakeStoreProductDto[] responseAllProductBody =   responseEntityAllProduct.getBody();
        // List<FakeStoreProductDto> productList = Arrays.asList(responseAllProductBody);
        for (FakeStoreProductDto fakeStoreProductDto : productList) {
            resultList.add(fakeStoreProductDto);
        }
//        int size = productList.size();
//        for(int i  = 0 ; i < size ; i++){
//           resultList.add(convertToGenericProductDTO(productList.get(i)));
//        }

        return resultList;
    }

    // In delete product we can use direct delete option but our ask is return an object also , so for that we need to find a way to how to delete and return the object

    public FakeStoreProductDto deleteProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.execute(specificProductUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);
        return responseEntity.getBody();
    }


    public FakeStoreProductDto createProduct(GenericProductDTO genericProductDTO) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.postForEntity(genericProducturl, genericProductDTO, FakeStoreProductDto.class);
        return responseEntity.getBody();
    }


    public FakeStoreProductDto updateProductById(Long id, GenericProductDTO genericProductDTO) {

        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(genericProductDTO, FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.execute(specificProductUrl, HttpMethod.PUT, requestCallback, responseExtractor, id);
        return responseEntity.getBody();
    }
}
