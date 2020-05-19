package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: LJJ
 * @Program: demo1
 * @Description:
 * @Create: 2020-05-11 19:54:54
 * @Modified By:
 */

@RestController
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping()
    public Map<String, String> hello(){
        Map<String, String> map = new HashMap<>();
        map.put("hello", "world!");
        return map;
    }

    @GetMapping("/rest")
    public void rest(){
        System.out.println(restTemplate.getClass().getSimpleName());
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }
}
