package com.example.demo.dto.Manga;

import com.example.demo.models.Manga.MangaStatus;
import lombok.Data;

import java.util.Set;

@Data
public class MangaRequest {

    private String title;

    private String slug;

    private String description;

    private String coverImage;

    private String bannerImage;

    private String author;

    private MangaStatus status;

    private Boolean hot;

    private Boolean featured;

    private Boolean newManga;

    private Set<Long> categoryIds;
}