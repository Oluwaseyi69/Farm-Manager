package com.example.Farmer.s.Delight.dtos.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String email;
    private String password;
}
