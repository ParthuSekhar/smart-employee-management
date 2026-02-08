package com.parthu.smart_employee_management.controller;

import com.parthu.smart_employee_management.dto.AuthRequestDTO;
import com.parthu.smart_employee_management.dto.AuthResponseDTO;
import com.parthu.smart_employee_management.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public AuthResponseDTO login(@RequestBody AuthRequestDTO request) {

        // In-memory user validation (simple & correct for now)
        if (!"admin".equals(request.getUsername()) ||
            !"admin123".equals(request.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(request.getUsername());

        return new AuthResponseDTO(token);
    }
}
