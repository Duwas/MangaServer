package com.example.demo.dto.Chapter;

import lombok.Data;

@Data
public class ChapterRequest {

    private String title;
    private Integer chapterNumber;
    private Long mangaId;
    private String contentImage;
}