package com.example.Farmer.s.Delight.security.services;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
@Getter
public class JwtConfig {
    @Value("${jwt.keys}")
    private String jwtSecretKey;

    public String getJwtSecret(){
        return jwtSecretKey;
    }
}
