package com.productservice.productservice.Controller;


import com.productservice.productservice.dtos.ExceptionDto;
import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDTO;
import com.productservice.productservice.exception.ProductNotFoundException;
import com.productservice.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public GenericProductDTO getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {

    return productService.getProductById(id);
    }

    @GetMapping
    public List<GenericProductDTO> getAllProducts(){
        return  productService.getAllProducts();
    }

    @DeleteMapping("/{id}")
    public GenericProductDTO deleteProductById(@PathVariable("id") Long id){
         return  productService.deleteProductById(id);

         // return ResponseEntity.noContent().build(); // Returning 204 No Content if successful
    }
    @PostMapping
    public GenericProductDTO createProduct(@RequestBody GenericProductDTO genericProductDTO){
      return productService.createProduct(genericProductDTO);

    }

    @PatchMapping("/{id}")
    public GenericProductDTO updateProductById(@PathVariable("id") Long id , @RequestBody GenericProductDTO genericProductDTO){
        return productService.updateProductById(id,genericProductDTO);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    private ResponseEntity<ExceptionDto> handleProductNotFoundException(ProductNotFoundException productNotFoundException){
       ExceptionDto exceptionDto = new ExceptionDto();
       exceptionDto.setMessage(productNotFoundException.getMessage());
       exceptionDto.setHttpStatus(HttpStatus.NOT_FOUND);
        //System.out.println("got product not found exception");
        //here the staus code is still 200 ok, so need to change the staus also , so what we can do it
        ResponseEntity responseEntity = new ResponseEntity(exceptionDto,HttpStatus.NOT_FOUND);

        return responseEntity;
    }
}
