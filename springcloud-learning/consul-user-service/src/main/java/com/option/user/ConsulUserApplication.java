package com.option.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: LJJ
 * @Program: option-parent
 * @Description:
 * @Create: 2020-03-17 16:05:05
 * @Modified By:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsulUserApplication.class, args);
    }
}
