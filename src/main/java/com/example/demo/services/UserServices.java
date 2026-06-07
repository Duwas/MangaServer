package com.example.demo.services;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.dto.UserResponse;
import com.example.demo.mapper.UserMapper;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.dto.LoginRequest;
import java.util.List;
import org.springframework.stereotype.Service;
@Service
public class UserServices {

    //Register
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServices(UserRepository userRepository,
                       UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserResponse register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email đã tồn tại");
        }

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        user = userRepository.save(user);

        return userMapper.toResponse(user);
    }

    //Login
    public UserResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Email không tồn tại"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Mật khẩu không đúng");
        }

        return userMapper.toResponse(user);
    }

    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toResponse)
                .toList();
    }
}
