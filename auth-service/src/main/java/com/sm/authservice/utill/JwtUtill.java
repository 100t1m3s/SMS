package com.sm.authservice.utill;


import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtUtill {
    private final Key secureKey;

    public JwtUtill(@Value("${jwt.secret}") String secret) {

        //byte[] keyBytes = Base64.getDecoder().decode(secret.getBytes(StandardCharsets.UTF_8));
        byte[] keyBytes = Base64.getDecoder().decode(secret);

        this.secureKey = Keys.hmacShaKeyFor(keyBytes);

    }

    public String generateToken(String email, String role) {
        return Jwts.builder()
                .subject(email)
                .claim("role", role)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10h
                .signWith(secureKey)
                .compact();
    }

    public void validateToken(String token) {
        try {
            Jwts.parser().verifyWith((SecretKey) secureKey)
                    .build()
                    .parseSignedClaims(token);
        }
        catch (SignatureException e) {
            throw new JwtException("Invalid JWT signature");
        }
        catch (JwtException e) {
            throw new JwtException("Invalid JWT token");
        }
    }
}
