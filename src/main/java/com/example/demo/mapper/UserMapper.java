package com.example.demo.mapper;
import com.example.demo.dto.UserResponse;
import com.example.demo.models.User;
import org.springframework.stereotype.Component;
@Component
public class UserMapper {

    public UserResponse toResponse(User user) {
        UserResponse response = new UserResponse();

        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole());
        response.setStatus(user.getStatus());

        return response;
    }
}