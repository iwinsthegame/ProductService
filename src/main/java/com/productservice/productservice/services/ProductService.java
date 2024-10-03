package com.productservice.productservice.services;

import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ProductService {
    GenericProductDTO getProductById(Long id);
    List<GenericProductDTO> getAllProducts();
    void deleteProductById();
     GenericProductDTO createProduct(GenericProductDTO genericProductDTO);
    public void updateProductById();
}
