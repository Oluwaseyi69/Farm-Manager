package com.example.Farmer.s.Delight.dtos.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class RegisterUserResponse {
    private String email;
    private String token;
    private String message;
    private LocalDate registerDate;
}
