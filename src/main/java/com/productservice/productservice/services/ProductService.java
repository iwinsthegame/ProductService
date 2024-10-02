package com.productservice.productservice.services;

import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface ProductService {
    GenericProductDTO getProductById(Long id);
    void getAllProducts();
    void deleteProductById();
    void createProduct();
    public void updateProductById();


}
