package com.productservice.productservice.services;


import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDTO;
import com.productservice.productservice.exception.ProductNotFoundException;
import com.productservice.productservice.thirdPartyClients.fakeStoreClient.FakeStoreClientAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {
    private static final Logger logger = LoggerFactory.getLogger(FakeStoreProductService.class);
    private FakeStoreClientAdapter fakeStoreClientAdapter;

    FakeStoreProductService(FakeStoreClientAdapter fakeStoreClientAdapter){
        this.fakeStoreClientAdapter = fakeStoreClientAdapter;
    }


    private static GenericProductDTO convertToGenericProductDTO(FakeStoreProductDto fakeStoreProductDto) {
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
    public GenericProductDTO getProductById(Long id) throws ProductNotFoundException {
        return convertToGenericProductDTO(fakeStoreClientAdapter.getProductById(id));
    }


    @Override
    public List<GenericProductDTO> getAllProducts() {

        List<FakeStoreProductDto> fakeStoreProductDtos = fakeStoreClientAdapter.getAllProducts();
        List<GenericProductDTO> genericProductDTOS = new ArrayList<>();


        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            genericProductDTOS.add(convertToGenericProductDTO(fakeStoreProductDto));
        }

        return genericProductDTOS;
    }

    // In delete product we can use direct delete option but our ask is return an object also , so for that we need to find a way to how to delete and return the object
    @Override
    public GenericProductDTO deleteProductById(Long id) {

        return convertToGenericProductDTO(fakeStoreClientAdapter.deleteProductById(id));
    }

    @Override
    public GenericProductDTO createProduct(GenericProductDTO genericProductDTO) {
       return convertToGenericProductDTO(fakeStoreClientAdapter.createProduct(genericProductDTO));
    }

    @Override
    public GenericProductDTO updateProductById(Long id, GenericProductDTO genericProductDTO) {

       return convertToGenericProductDTO(fakeStoreClientAdapter.updateProductById(id,genericProductDTO));
    }
}
