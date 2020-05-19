package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: LJJ
 * @Program: springmvc-day1
 * @Description:
 * @Create: 2020-05-10 02:05:05
 * @Modified By:
 */
@Controller
@RequestMapping("/hello")
public class HelloController {
    @GetMapping("/world")
    public String index(){
        return "index";
    }
}
