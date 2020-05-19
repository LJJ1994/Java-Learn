package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Author: LJJ
 * @Program: demo1
 * @Description:
 * @Create: 2020-05-11 21:35:35
 * @Modified By:
 */
@ControllerAdvice
public class ProductExceptionController  {
    @ExceptionHandler(value = ProductionNotFoundException.class)
    public ResponseEntity<Object> exception(ProductionNotFoundException ex){
        return new ResponseEntity<>("product no found", HttpStatus.NOT_FOUND);
    }
}
