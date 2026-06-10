package com.example.demo.controller.Favorite;

import com.example.demo.dto.Favorite.FavoriteRequest;
import com.example.demo.dto.Favorite.FavoriteResponse;
import com.example.demo.services.FavoriteServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
@RequiredArgsConstructor
public class FavoriteController {

    private final FavoriteServices favoriteServices;

    @PostMapping
    public FavoriteResponse addFavorite(@RequestBody FavoriteRequest request) {
        return favoriteServices.addFavorite(request);
    }

    @GetMapping("/user/{userId}")
    public List<FavoriteResponse> getFavoritesByUser(@PathVariable Long userId) {
        return favoriteServices.getFavoritesByUser(userId);
    }

    @DeleteMapping("/{id}")
    public void deleteFavorite(@PathVariable Long id) {
        favoriteServices.deleteFavorite(id);
    }
}