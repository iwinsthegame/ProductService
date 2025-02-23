package com.productservice.productservice.services;

import com.productservice.productservice.dtos.GenericProductDTO;
import com.productservice.productservice.exception.ProductNotFoundException;
import com.productservice.productservice.model.Product;
import com.productservice.productservice.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Primary
@Service
public class SelfProductServiceImpl implements ProductService{
    private ProductRepository productRepository;

    public SelfProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public GenericProductDTO getProductById(Long id) throws ProductNotFoundException {
        //make a db call and get the product with given id

        GenericProductDTO genericProductDTO = new GenericProductDTO();

        Optional<Product> optionalProduct = productRepository.findById(UUID.fromString("8702c538-32dd-4ff7-81fa-12d67331358b"));
         Product product = optionalProduct.get();


         genericProductDTO.setTitle(product.getTitle());
         genericProductDTO.setImage(product.getImage());
         genericProductDTO.setCategory(product.getCategory().toString());
         genericProductDTO.setDescription(product.getDescription());
         genericProductDTO.setPrice(0);


        return genericProductDTO;
    }

    @Override
    public List<GenericProductDTO> getAllProducts() {
        return null;
    }

    @Override
    public GenericProductDTO deleteProductById(Long id) {
        return null;
    }

    @Override
    public GenericProductDTO createProduct(GenericProductDTO genericProductDTO) {
        return null;
    }

    @Override
    public GenericProductDTO updateProductById(Long id, GenericProductDTO genericProductDTO) {
        return null;
    }
}
