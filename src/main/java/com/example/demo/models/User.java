package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.persistence.Table;
@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "NVARCHAR(30)")
    private String name;

    @Column(unique = true)
    private String email;

    private String password;
    private String phone;
    private LocalDate birthday;

    @Column(columnDefinition = "NVARCHAR(10)")
    private String gender;

    @Column(columnDefinition = "NVARCHAR(100)")
    private String address;

    private String avatarUrl;

    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;
    private Long status = 1L;
    private LocalDateTime createdAt = LocalDateTime.now();
}

