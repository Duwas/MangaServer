package com.example.demo.controller.AuthorRequest;

import com.example.demo.dto.Author.AuthorRequest;
import com.example.demo.dto.Author.AuthorResponse;
import com.example.demo.services.AuthorRequestServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/author-requests")
@RequiredArgsConstructor
public class AuthorRequestController {

    private final AuthorRequestServices authorRequestServices;

    @PostMapping
    public AuthorResponse createAuthorRequest(
            @RequestBody AuthorRequest request) {

        return authorRequestServices
                .createAuthorRequest(request);
    }

    @GetMapping
    public List<AuthorResponse> getAllAuthorRequests() {

        return authorRequestServices
                .getAllAuthorRequests();
    }

    @PutMapping("/{id}/approve")
    public AuthorResponse approveAuthorRequest(
            @PathVariable Long id) {

        return authorRequestServices
                .approveAuthorRequest(id);
    }

    @PutMapping("/{id}/reject")
    public AuthorResponse rejectAuthorRequest(
            @PathVariable Long id) {

        return authorRequestServices
                .rejectAuthorRequest(id);
    }
}