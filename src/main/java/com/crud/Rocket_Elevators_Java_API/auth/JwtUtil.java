package com.crud.Rocket_Elevators_Java_API.auth;

import com.crud.Rocket_Elevators_Java_API.models.Users;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Value;

@Component
public class JwtUtil {

    @Value("${app.jwt.secret}")
    private String secret;

    public String generateAccessToken(Users user) {
        return Jwts.builder()
                .setSubject(String.format("%s,%s", user.getId(), user.getEmail()))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
}

