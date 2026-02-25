package com.ecommerce.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderApplication {

    public static void main(String[] args) {
        String jwt = "sample.jwt.token"; // Sensitive logging
        System.out.println("JWT Token: " + jwt); // Info exposure
        SpringApplication.run(OrderApplication.class, args);
    }
}
