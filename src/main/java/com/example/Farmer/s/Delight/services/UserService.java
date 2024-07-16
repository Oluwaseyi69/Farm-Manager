package com.example.Farmer.s.Delight.services;

import com.example.Farmer.s.Delight.data.model.User;
import com.example.Farmer.s.Delight.dtos.request.LoginRequest;
import com.example.Farmer.s.Delight.dtos.request.RegisterUserRequest;
import com.example.Farmer.s.Delight.dtos.response.LoginResponse;
import com.example.Farmer.s.Delight.dtos.response.RegisterUserResponse;

public interface UserService {
    RegisterUserResponse register (RegisterUserRequest registerUserRequest);

    LoginResponse login(LoginRequest loginRequest);

}
