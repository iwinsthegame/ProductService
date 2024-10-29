package com.productservice.productservice.Controller;


import com.productservice.productservice.dtos.ExceptionDto;
import com.productservice.productservice.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ProductControllerAdvices {

    @ExceptionHandler(ProductNotFoundException.class)
    // @ResponseStatus(HttpStatus.NOT_FOUND)
    private ResponseEntity<ExceptionDto> handleProductNotFoundException(ProductNotFoundException productNotFoundException) {
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage(productNotFoundException.getMessage());
        exceptionDto.setHttpStatus(HttpStatus.NOT_FOUND);
        //System.out.println("got product not found exception");
        //here the staus code is still 200 ok, so need to change the staus also , so what we can do it
        //@ResponseStatus(HttpStatus.NOT_FOUND)  -> we can set it at the top instead of writing below code
        //and here we are creating an object of responseEntity just beacuse to change the stauts of code ...but now as we have solve the issue by adding response status at the top
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }

    // --- we can use below code also
//@ExceptionHandler(ProductNotFoundException.class)
//@ResponseStatus(HttpStatus.NOT_FOUND)
//@ResponseBody()
//private ExceptionDto handleProductNotFoundException(ProductNotFoundException productNotFoundException){
//    ExceptionDto exceptionDto = new ExceptionDto();
//    exceptionDto.setMessage(productNotFoundException.getMessage());
//    exceptionDto.setHttpStatus(HttpStatus.NOT_FOUND);
//    //System.out.println("got product not found exception");
//    //here the staus code is still 200 ok, so need to change the staus also , so what we can do it
//    //@ResponseStatus(HttpStatus.NOT_FOUND)  -> we can set it at the top instead of writing below code
//    //and here we are creating an object of responseEntity just beacuse to change the stauts of code ...but now as we have solve the issue by adding response status at the top
//    return exceptionDto;
//}


    // its is just example we can handle multiple types of exception not recommended below two methods
//    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
//    private ResponseEntity<Exception> handleArrayindexOutOfBoundException(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
//        return null;
//    }
//
//    @ExceptionHandler(NullPointerException.class)
//    private ResponseEntity<ExceptionDto> handleNullPointerException(NullPointerException nullPointerException){
//        return null;
//    }

}
