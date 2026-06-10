package com.example.demo.controller.Chapter;

import com.example.demo.dto.Chapter.ChapterRequest;
import com.example.demo.dto.Chapter.ChapterResponse;
import com.example.demo.services.ChapterServices;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chapters")
@RequiredArgsConstructor
public class ChapterController {

    private final ChapterServices chapterServices;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ChapterResponse createChapter(
            @RequestBody ChapterRequest request) {

        return chapterServices.createChapter(request);
    }

    @GetMapping
    public List<ChapterResponse> getAllChapters() {

        return chapterServices.getAllChapters();
    }

    @GetMapping("/{id}")
    public ChapterResponse getChapterById(
            @PathVariable Long id) {

        return chapterServices.getChapterById(id);
    }

    @GetMapping("/manga/{mangaId}")
    public List<ChapterResponse> getChaptersByManga(
            @PathVariable Long mangaId) {

        return chapterServices.getChaptersByManga(mangaId);
    }
    @PutMapping("/{id}")
    public ChapterResponse updateChapter(
            @PathVariable Long id,
            @RequestBody ChapterRequest request) {

        return chapterServices.updateChapter(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteChapter(@PathVariable Long id) {
        chapterServices.deleteChapter(id);
    }
}