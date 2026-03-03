package com.ecommerce.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.MessageDigest;

@SpringBootApplication
public class AuthApplication {

    private static final String JWT_SECRET = "HardcodedJWTSecret123"; // Vulnerable

    public static void main(String[] args) throws Exception {
        String password = "admin123";
        MessageDigest md = MessageDigest.getInstance("MD5"); // Weak hashing
        md.digest(password.getBytes());

        SpringApplication.run(AuthApplication.class, args);
    }
}
