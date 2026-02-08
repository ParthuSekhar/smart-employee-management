package com.parthu.smart_employee_management.controller;

import com.parthu.smart_employee_management.security.JwtUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    // ✅ REQUIRED constructor
    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public String login() {
        // Temporary success response
        return "LOGIN OK";
    }
}
