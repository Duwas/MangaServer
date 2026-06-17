package com.example.demo.dto.Chapter;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ChapterResponse {

    private Long id;

    private String title;

    private Integer chapterNumber;

    private List<String> contentImages;

    private Long views;

    private LocalDateTime createdAt;

    private Long mangaId;

    private String mangaTitle;
}