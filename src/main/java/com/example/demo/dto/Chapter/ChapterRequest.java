package com.example.demo.dto.Chapter;

import lombok.Data;

import java.util.List;

@Data
public class ChapterRequest {

    private String title;

    private Integer chapterNumber;

    private List<String> contentImages;

    private Long mangaId;
}