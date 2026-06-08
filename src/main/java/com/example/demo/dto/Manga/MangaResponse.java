package com.example.demo.dto.Manga;

import com.example.demo.models.Manga.MangaStatus;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class MangaResponse {

    private Long id;
    private String title;
    private String description;
    private String coverImage;
    private String authorName;
    private Integer chapterCount;
    private Long views;
    private MangaStatus status;
    private Boolean approved;
    private LocalDateTime createdAt;
    private Set<String> categories;
}