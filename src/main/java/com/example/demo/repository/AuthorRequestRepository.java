package com.example.demo.repository;

import com.example.demo.models.AuthorRequest.AuthorRequest;
import com.example.demo.models.AuthorRequest.AuthorRequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRequestRepository extends JpaRepository<AuthorRequest, Long> {

    List<AuthorRequest> findByStatus(String status);

    boolean existsByUserIdAndStatus(Long userId, AuthorRequestStatus status);
}