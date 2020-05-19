package com.example.demo.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author: LJJ
 * @Program: demo1
 * @Description:
 * @Create: 2020-05-11 21:47:47
 * @Modified By:
 */
@Component
public class ProductInterceptorConfig implements WebMvcConfigurer {
    @Autowired
    private ProductInterceptor productInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(productInterceptor);
    }
}
