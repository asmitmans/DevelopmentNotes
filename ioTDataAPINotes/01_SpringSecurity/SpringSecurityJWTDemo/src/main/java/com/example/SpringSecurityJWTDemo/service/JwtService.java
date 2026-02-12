package com.example.SpringSecurityJWTDemo.service;

public interface JwtService {
    String generateToken(org.springframework.security.core.userdetails.UserDetails user);

    String extractUsername(String token);

    <T> T extractClaim(String token, java.util.function.Function<io.jsonwebtoken.Claims, T> resolver);

    boolean isTokenValid(String token, org.springframework.security.core.userdetails.UserDetails user);
}
