package com.example.demo.exception;

/**
 * @Author: LJJ
 * @Program: demo1
 * @Description:
 * @Create: 2020-05-11 21:33:33
 * @Modified By:
 */
public class ProductionNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String message;
    public ProductionNotFoundException(String message){
        this.message = message;
    }
}
