package com.bookservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class BookserviceApplication {


    public static void main(String[] args) {
        System.out.println("APP_NAME: " + System.getProperty("APP_NAME"));
        SpringApplication.run(BookserviceApplication.class, args);
    }

}
