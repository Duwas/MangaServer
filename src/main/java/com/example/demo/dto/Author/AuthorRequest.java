package com.example.demo.dto.Author;

import lombok.Data;

@Data
public class AuthorRequest {

    private Long userId;

    private String reason;
}