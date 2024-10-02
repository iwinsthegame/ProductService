package com.productservice.productservice.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    private static final Logger logger = LoggerFactory.getLogger(FakeStoreProductService.class);
    private RestTemplateBuilder restTemplateBuilder;
    private String getProductUrl = "https://fakestoreapi.com/products/1";

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
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.getForEntity(getProductUrl, FakeStoreProductDto.class);

//convert fakstoreproductDTO to genericproduct DTO before returning


        return convertToGenericProductDTO(responseEntity.getBody());
    }

//    @Override
//    public FakeStoreProductDto getProductById(Long id) {
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        // Modify the URL to include the product ID
//        String url = getProductUrl + id;
//
//        try {
//            // Fetch the response as a String
//            ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
//
//            if (responseEntity.getStatusCode() == HttpStatus.OK) {
//                String jsonResponse = responseEntity.getBody();
//                ObjectMapper objectMapper = new ObjectMapper();
//                // Manually convert the JSON string to your DTO
//                FakeStoreProductDto product = objectMapper.readValue(jsonResponse, FakeStoreProductDto.class);
//                return product;
//            } else {
//                throw new RuntimeException("Failed to fetch product. HTTP Status: " + responseEntity.getStatusCode());
//            }
//
//        } catch (Exception e) {
//            logger.error("Error while fetching product with ID " + id, e);
//            throw new RuntimeException("Error while fetching product with ID " + id, e);
//        }
//    }



    @Override
    public void getAllProducts() {

    }

    @Override
    public void deleteProductById() {

    }

    @Override
    public void createProduct() {

    }

    @Override
    public void updateProductById() {

    }
}
