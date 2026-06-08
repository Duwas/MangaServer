package com.example.demo.dto;

import com.example.demo.models.Role;
import lombok.Data;

@Data
public class UserResponse {

    private Long id;
    private String name;
    private String email;
    private Role role;
    private Long status;
}