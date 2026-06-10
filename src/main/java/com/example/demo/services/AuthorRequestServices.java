package com.example.demo.services;

import com.example.demo.dto.Author.AuthorRequest;
import com.example.demo.dto.Author.AuthorResponse;
import com.example.demo.models.AuthorRequest.AuthorRequestStatus;
import com.example.demo.models.Role;
import com.example.demo.models.User;
import com.example.demo.repository.AuthorRequestRepository;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorRequestServices {

    private final AuthorRequestRepository authorRequestRepository;
    private final UserRepository userRepository;

    public AuthorResponse createAuthorRequest(
            AuthorRequest request) {

        if (authorRequestRepository.existsByUserIdAndStatus(
                request.getUserId(),
                AuthorRequestStatus.PENDING)) {

            throw new RuntimeException(
                    "Bạn đã gửi yêu cầu rồi");
        }

        User user = userRepository.findById(
                        request.getUserId())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Không tìm thấy user"));

        com.example.demo.models.AuthorRequest.AuthorRequest
                authorRequest =
                new com.example.demo.models.AuthorRequest.AuthorRequest();

        authorRequest.setUser(user);
        authorRequest.setReason(request.getReason());

        return toResponse(
                authorRequestRepository.save(authorRequest)
        );
    }

    public List<AuthorResponse> getAllAuthorRequests() {

        return authorRequestRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public AuthorResponse approveAuthorRequest(
            Long id) {

        com.example.demo.models.AuthorRequest.AuthorRequest request =
                authorRequestRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Không tìm thấy yêu cầu"));

        request.setStatus(
                AuthorRequestStatus.APPROVED);

        User user = request.getUser();

        user.setRole(Role.AUTHOR);

        userRepository.save(user);

        return toResponse(
                authorRequestRepository.save(request)
        );
    }

    public AuthorResponse rejectAuthorRequest(
            Long id) {

        com.example.demo.models.AuthorRequest.AuthorRequest request =
                authorRequestRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Không tìm thấy yêu cầu"));

        request.setStatus(
                AuthorRequestStatus.REJECTED);

        return toResponse(
                authorRequestRepository.save(request)
        );
    }

    private AuthorResponse toResponse(
            com.example.demo.models.AuthorRequest.AuthorRequest request) {

        AuthorResponse response =
                new AuthorResponse();

        response.setId(request.getId());
        response.setUserId(
                request.getUser().getId());

        response.setUserName(
                request.getUser().getName());

        response.setReason(
                request.getReason());

        response.setStatus(
                request.getStatus());

        response.setCreatedAt(
                request.getCreatedAt());

        return response;
    }
}