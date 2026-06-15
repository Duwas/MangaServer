package com.example.demo.dto.Manga;

import com.example.demo.models.Manga.MangaStatus;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class MangaResponse {

    private Long id;

    private String title;

    private String slug;

    private String description;

    private String coverImage;

    private String bannerImage;

    private String authorName;

    private String artist;

    private Integer chapterCount;

    private Long views;

    private Double averageRating;

    private Integer ratingCount;

    private MangaStatus status;

    private Boolean approved;

    private Boolean hot;

    private Boolean featured;

    private Boolean newManga;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Set<String> categories;
}