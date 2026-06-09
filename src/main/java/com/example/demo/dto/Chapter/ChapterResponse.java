package com.example.demo.dto.Chapter;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ChapterResponse {

    private Long id;
    private String title;
    private Integer chapterNumber;
    private Long mangaId;
    private String mangaTitle;
    private String contentImage;
    private LocalDateTime createdAt;
}