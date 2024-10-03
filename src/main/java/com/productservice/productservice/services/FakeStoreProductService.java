package com.productservice.productservice.services;


import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    private static final Logger logger = LoggerFactory.getLogger(FakeStoreProductService.class);
    private RestTemplateBuilder restTemplateBuilder;
    private String getProductUrl = "https://fakestoreapi.com/products/{id}";
    private String genericProducturl = "https://fakestoreapi.com/products";

    FakeStoreProductService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }

    private static GenericProductDTO convertToGenericProductDTO(FakeStoreProductDto fakeStoreProductDto){
        GenericProductDTO genericProductDTO = new GenericProductDTO();
        genericProductDTO.setId(fakeStoreProductDto.getId());
        genericProductDTO.setImage(fakeStoreProductDto.getImage());
        genericProductDTO.setCategory(fakeStoreProductDto.getCategory());
        genericProductDTO.setDescription(fakeStoreProductDto.getDescription());
        genericProductDTO.setTitle(fakeStoreProductDto.getTitle());
        genericProductDTO.setPrice(fakeStoreProductDto.getPrice());
        return genericProductDTO;
    }

    @Override
    public GenericProductDTO getProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.getForEntity(getProductUrl, FakeStoreProductDto.class,id);

       //convert fakstoreproductDTO to genericproduct DTO before returning

        return convertToGenericProductDTO(responseEntity.getBody());
    }




    @Override
    public List<GenericProductDTO> getAllProducts() {
        List<GenericProductDTO> resultList = new ArrayList<>();
      RestTemplate restTemplate = restTemplateBuilder.build();
     ResponseEntity<FakeStoreProductDto[]> responseEntityAllProduct = restTemplate.getForEntity(genericProducturl,FakeStoreProductDto[].class);
        List<FakeStoreProductDto> productList = List.of(responseEntityAllProduct.getBody());
        //FakeStoreProductDto[] responseAllProductBody =   responseEntityAllProduct.getBody();
       // List<FakeStoreProductDto> productList = Arrays.asList(responseAllProductBody);
        for(FakeStoreProductDto fakeStoreProductDto : productList){
            resultList.add(convertToGenericProductDTO(fakeStoreProductDto));
        }
//        int size = productList.size();
//        for(int i  = 0 ; i < size ; i++){
//           resultList.add(convertToGenericProductDTO(productList.get(i)));
//        }

    return resultList;
    }

    @Override
    public void deleteProductById() {
    }

    @Override
    public GenericProductDTO createProduct(GenericProductDTO genericProductDTO) {
        RestTemplate restTemplate = restTemplateBuilder.build();
       ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.postForEntity(genericProducturl,genericProductDTO,FakeStoreProductDto.class);
       return convertToGenericProductDTO(responseEntity.getBody());
    }

    @Override
    public void updateProductById() {

    }
}
