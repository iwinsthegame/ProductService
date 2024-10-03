package com.productservice.productservice.Controller;


import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDTO;
import com.productservice.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

   private  ProductService productService;
   @Autowired
    ProductController(@Qualifier("fakeStoreProductService") ProductService productService){
     this.productService = productService;
    }
    //localhost:8080/products/1234
    //All the api in this controller are going to hosted in products endpoints , so at class level we can define it v
    //vis using RequestMapping
    //you need to pass id here , so you will get id or variable from path of the URL
    @GetMapping("/{id}")
    public GenericProductDTO getProductById(@PathVariable("id") Long id){

    return productService.getProductById(id);
    }

    @GetMapping
    public List<GenericProductDTO> getAllProducts(){
        return  productService.getAllProducts();
    }

    public void deleteProductById(){

    }
    @PostMapping("/create")
    public void createProduct(@RequestBody FakeStoreProductDto fakeStoreProductDto){
//    return productService.createProduct(fakeStoreProductDto);

    }

    public void updateProductById(){

    }
}
