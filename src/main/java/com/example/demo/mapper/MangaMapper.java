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
        response.setDescription(manga.getDescription());
        response.setCoverImage(manga.getCoverImage());

        response.setAuthorName(
                manga.getAuthor() != null
                        ? manga.getAuthor().getName()
                        : null
        );

        response.setViews(manga.getViews());
        response.setChapterCount(manga.getChapterCount());
        response.setStatus(manga.getStatus());
        response.setApproved(manga.getApproved());
        response.setCreatedAt(manga.getCreatedAt());

        response.setCategories(
                manga.getCategories()
                        .stream()
                        .map(Category::getName)
                        .collect(Collectors.toSet())
        );

        return response;
    }
}