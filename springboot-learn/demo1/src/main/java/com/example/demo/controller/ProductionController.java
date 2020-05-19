package com.example.demo.controller;

import com.example.demo.exception.ProductionNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: LJJ
 * @Program: demo1
 * @Description:
 * @Create: 2020-05-11 21:37:37
 * @Modified By:
 */
@RestController
@RequestMapping("/product")
public class ProductionController {
    @GetMapping("/ex")
    public void exception(){
        throw new ProductionNotFoundException("产品参数异常");
    }
}
