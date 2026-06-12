package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.dto.UserResponse;
import com.example.demo.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserServices userServices;

    @PostMapping("/register")
    public UserResponse register(@RequestBody RegisterRequest request) {
        return userServices.register(request);
    }

    @PostMapping("/login")
    public UserResponse login(@RequestBody LoginRequest request) {
        return userServices.login(request);
    }

    @GetMapping("/users")
    public List<UserResponse> getAllUsers() {
        return userServices.getAllUsers();
    }
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id) {
        return userServices.deleteUser(id);
    }
}