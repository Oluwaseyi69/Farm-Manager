package com.example.Farmer.s.Delight.security.services;

import com.example.Farmer.s.Delight.data.model.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    String generateToken(UserDetails user);
    boolean validateToken(String token, UserDetails user);
}
