package com.itheima.exception;

/**
 * @Author: LJJ
 * @Program: springmvc-day1
 * @Description:
 * @Create: 2020-05-10 05:13:13
 * @Modified By:
 */
public class CustomException extends Exception {
    private String message;
    public CustomException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
