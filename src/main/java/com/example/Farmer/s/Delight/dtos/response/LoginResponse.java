package com.example.Farmer.s.Delight.dtos.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LoginResponse {
    private String message;
    private String token;
}
