package com.example.SpringSecurityJWTDemo.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtServiceImpl implements JwtService {

    private final SecretKey signingKey;
    private final long ttlSeconds;
    private final String issuer;

    public JwtServiceImpl(
            @Value("${security.jwt.secret-base64}") String secretBase64,
            @Value("${security.jwt.ttl-seconds}") long ttlSeconds,
            @Value("${security.jwt.issuer}") String issuer
    ){
        this.signingKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretBase64));
        this.ttlSeconds = ttlSeconds;
        this.issuer = issuer;
    }

    @Override
    public String generateToken(UserDetails user) {
        Instant now = Instant.now();
        Instant exp = now.plusSeconds(ttlSeconds);

        return Jwts.builder()
                .subject(user.getUsername())
                .issuer(issuer)
                .issuedAt(Date.from(now))
                .expiration(Date.from(exp))
                .signWith(signingKey)
                .compact();
    }

    @Override
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    @Override
    public <T> T extractClaim(String token, Function<Claims, T> resolver) {
        Claims claims = Jwts.parser()
                .verifyWith(signingKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return resolver.apply(claims);
    }

    @Override
    public boolean isTokenValid(String token, UserDetails user) {

        try {
            String username = extractUsername(token);
            if (!user.getUsername().equals(username)) {
                return false;
            }

            Date exp = extractClaim(token, Claims::getExpiration);
            return exp != null && exp.after(new Date());
        } catch (JwtException | IllegalArgumentException ex) {
            return false;
        }
    }
}
