package com.example.demo.mapper;

import com.example.demo.dto.Manga.MangaResponse;
import com.example.demo.models.Manga.Category;
import com.example.demo.models.Manga.Manga;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class MangaMapper {

    public MangaResponse toResponse(Manga manga) {

        MangaResponse response = new MangaResponse();

        response.setId(manga.getId());
        response.setTitle(manga.getTitle());
        response.setSlug(manga.getSlug());
        response.setDescription(manga.getDescription());
        response.setCoverImage(manga.getCoverImage());
        response.setBannerImage(manga.getBannerImage());
        response.setAuthorName(manga.getAuthorName());
        response.setArtist(manga.getArtist());

        response.setChapterCount(manga.getChapterCount());
        response.setViews(manga.getViews());
        response.setAverageRating(manga.getAverageRating());
        response.setRatingCount(manga.getRatingCount());

        response.setStatus(manga.getStatus());
        response.setApproved(manga.getApproved());
        response.setHot(manga.getHot());
        response.setFeatured(manga.getFeatured());
        response.setNewManga(manga.getNewManga());

        response.setCreatedAt(manga.getCreatedAt());
        response.setUpdatedAt(manga.getUpdatedAt());

        if (manga.getCategories() != null) {
            response.setCategories(
                    manga.getCategories()
                            .stream()
                            .map(Category::getName)
                            .collect(Collectors.toSet())
            );
        }

        return response;
    }
}