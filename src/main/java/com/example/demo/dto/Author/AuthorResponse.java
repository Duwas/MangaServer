package com.example.demo.dto.Author;

import com.example.demo.models.AuthorRequest.AuthorRequestStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AuthorResponse {

    private Long id;

    private Long userId;

    private String userName;

    private String reason;

    private AuthorRequestStatus status;

    private LocalDateTime createdAt;
}