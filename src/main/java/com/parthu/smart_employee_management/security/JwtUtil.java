package com.parthu.smart_employee_management.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    // ✅ Secure 256-bit key
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hour

    // 🔐 Generate token
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .claim("role", "ADMIN")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key)
                .compact();
    }

    // 📤 Extract username
    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    // 📤 Extract role
    public String extractRole(String token) {
        return extractAllClaims(token).get("role", String.class);
    }

    // ✅ Validate token
    public boolean isTokenValid(String token) {
        try {
            extractAllClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // 🔍 Common parser
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
