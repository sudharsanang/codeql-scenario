package com.ecommerce.auth;

public class VulnerableExec {

    public void run(String input) throws Exception {

        // 🚨 HIGH: Command Injection
        Runtime.getRuntime().exec(input);
    }
}
