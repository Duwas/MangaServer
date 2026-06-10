package com.example.demo.dto.Favorite;

import lombok.Data;

@Data
public class FavoriteRequest {
    private Long userId;
    private Long mangaId;
}