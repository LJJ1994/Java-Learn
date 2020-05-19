package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: LJJ
 * @Program: demo1
 * @Description:
 * @Create: 2020-05-11 22:51:51
 * @Modified By:
 */
@Controller
@RequestMapping("/index")
public class IndexController {
    @RequestMapping
    public String index(){
        return "index";
    }
}
