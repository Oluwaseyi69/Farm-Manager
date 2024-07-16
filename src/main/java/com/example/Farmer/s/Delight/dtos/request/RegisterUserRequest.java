package com.example.Farmer.s.Delight.dtos.request;

import com.example.Farmer.s.Delight.data.model.Role;
import lombok.Data;

@Data
public class RegisterUserRequest {
    private String username;
    private String email;
    private String password;
    private Role role;
}
