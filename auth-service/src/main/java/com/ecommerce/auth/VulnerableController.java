package com.ecommerce.auth;

import java.sql.*;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

@RestController
public class VulnerableController {

    @GetMapping("/user")
    public String getUser(HttpServletRequest request) throws Exception {

        String userId = request.getParameter("id");

        Connection conn = DriverManager.getConnection("jdbc:h2:mem:test");
        Statement stmt = conn.createStatement();

        // 🚨 SQL Injection (High Severity)
        String query = "SELECT * FROM users WHERE id = " + userId;
        stmt.executeQuery(query);

        return "Done";
    }
}
