package com.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: LJJ
 * @Program: option-parent
 * @Description:
 * @Create: 2020-03-17 16:25:25
 * @Modified By:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulRibbonApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsulRibbonApplication.class, args);
    }
}
