package com.example.demo.services;

import com.example.demo.dto.Favorite.FavoriteRequest;
import com.example.demo.dto.Favorite.FavoriteResponse;
import com.example.demo.models.Favorite.Favorite;
import com.example.demo.models.Manga.Manga;
import com.example.demo.models.User;
import com.example.demo.repository.FavoriteRepository;
import com.example.demo.repository.MangaRepository;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FavoriteServices {

    private final FavoriteRepository favoriteRepository;
    private final UserRepository userRepository;
    private final MangaRepository mangaRepository;

    public FavoriteResponse addFavorite(FavoriteRequest request) {

        if (favoriteRepository.findByUserIdAndMangaId(
                request.getUserId(), request.getMangaId()).isPresent()) {
            throw new RuntimeException("Truyện đã có trong danh sách yêu thích");
        }

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy user"));

        Manga manga = mangaRepository.findById(request.getMangaId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy truyện"));

        Favorite favorite = new Favorite();
        favorite.setUser(user);
        favorite.setManga(manga);

        return toResponse(favoriteRepository.save(favorite));
    }

    public List<FavoriteResponse> getFavoritesByUser(Long userId) {
        return favoriteRepository.findByUserId(userId)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public void deleteFavorite(Long id) {
        favoriteRepository.deleteById(id);
    }

    private FavoriteResponse toResponse(Favorite favorite) {
        FavoriteResponse response = new FavoriteResponse();

        response.setId(favorite.getId());
        response.setUserId(favorite.getUser().getId());
        response.setUserName(favorite.getUser().getName());
        response.setMangaId(favorite.getManga().getId());
        response.setMangaTitle(favorite.getManga().getTitle());

        return response;
    }
}