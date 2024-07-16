package com.example.Farmer.s.Delight.controller;

import com.example.Farmer.s.Delight.dtos.request.LoginRequest;
import com.example.Farmer.s.Delight.dtos.request.RegisterUserRequest;
import com.example.Farmer.s.Delight.dtos.response.LoginResponse;
import com.example.Farmer.s.Delight.dtos.response.RegisterUserResponse;
import com.example.Farmer.s.Delight.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "http://localhost:3000/")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/registerUser")
    public ResponseEntity<?> register(@RequestBody RegisterUserRequest registerUserRequest){
        RegisterUserResponse response = userService.register(registerUserRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("/logIn")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        LoginResponse response = userService.login(loginRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
