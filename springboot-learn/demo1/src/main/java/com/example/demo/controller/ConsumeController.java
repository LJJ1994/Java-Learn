package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.function.ServerRequest;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

/**
 * @Author: LJJ
 * @Program: demo1
 * @Description:
 * @Create: 2020-05-11 22:25:25
 * @Modified By:
 */
@RestController
@RequestMapping("/consume")
public class ConsumeController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/product")
    public void product(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Map> exchange = restTemplate.exchange("http://localhost:8080/hello", HttpMethod.GET, entity, Map.class);
        Map body = exchange.getBody();
        assert body != null;
        System.out.println(body.get("hello"));
    }
}
