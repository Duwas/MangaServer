package com.example.demo.dto.Favorite;

import lombok.Data;

@Data
public class FavoriteResponse {
    private Long id;
    private Long userId;
    private String userName;
    private Long mangaId;
    private String mangaTitle;
}