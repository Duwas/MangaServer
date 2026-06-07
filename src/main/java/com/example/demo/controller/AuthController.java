package com.example.demo.controller;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.dto.UserResponse;
import com.example.demo.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private UserServices userServices;

    @PostMapping("/register")
    public UserResponse register(@RequestBody RegisterRequest request) {
        return userServices.register(request);
    }



}