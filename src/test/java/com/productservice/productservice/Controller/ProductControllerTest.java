package com.productservice.productservice.Controller;


import com.productservice.productservice.exception.ProductNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProductControllerTest {

       private ProductController productController;

       @Autowired
       ProductControllerTest(ProductController productController){
           this.productController = productController;
       }

    @Test
    @DisplayName("Test OnePlusOne")
    void TestOneplusOneIsTwoOrNot(){
        //assert(21 == 1+1);
        //CHECK THE EXPECTED VALUE (2) vs the output of the expression
        //if assert is true, test case succeeds , else fails

       // assertEquals(21,1+1,"OnePlusOne should be 2");
        assertTrue(false);
    }

    @Test
    void testGetProductById(){
        assertThrows(ProductNotFoundException.class,() -> productController.getProductById(1000L));
    }

}
