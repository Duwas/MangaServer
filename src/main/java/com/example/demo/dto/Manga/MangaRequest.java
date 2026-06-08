package com.example.demo.dto.Manga;

import com.example.demo.models.Manga.MangaStatus;
import lombok.Data;

import java.util.Set;

@Data
public class MangaRequest {

    private String title;
    private String description;
    private String coverImage;
    private MangaStatus status;
    private Set<Long> categoryIds;
}