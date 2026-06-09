package com.example.demo.services;

import com.example.demo.dto.Chapter.ChapterRequest;
import com.example.demo.dto.Chapter.ChapterResponse;
import com.example.demo.mapper.ChapterMapper;
import com.example.demo.models.Chapter.Chapter;
import com.example.demo.models.Manga.Manga;
import com.example.demo.repository.ChapterRepository;
import com.example.demo.repository.MangaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChapterServices {

    private final ChapterRepository chapterRepository;
    private final MangaRepository mangaRepository;
    private final ChapterMapper chapterMapper;

    public ChapterResponse createChapter(
            ChapterRequest request) {

        Manga manga = mangaRepository.findById(
                request.getMangaId())
                .orElseThrow(() ->
                        new RuntimeException("Không tìm thấy truyện"));

        Chapter chapter = new Chapter();
        chapter.setContentImage(
                request.getContentImage()
        );
        chapter.setTitle(request.getTitle());
        chapter.setChapterNumber(
                request.getChapterNumber());

        chapter.setManga(manga);

        chapter = chapterRepository.save(chapter);

        return chapterMapper.toResponse(chapter);
    }

    public List<ChapterResponse> getAllChapters() {

        return chapterRepository.findAll()
                .stream()
                .map(chapterMapper::toResponse)
                .toList();
    }

    public List<ChapterResponse> getChaptersByManga(
            Long mangaId) {

        return chapterRepository.findByMangaId(mangaId)
                .stream()
                .map(chapterMapper::toResponse)
                .toList();
    }

    public ChapterResponse getChapterById(Long id) {

        Chapter chapter = chapterRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Không tìm thấy chapter"));

        return chapterMapper.toResponse(chapter);
    }
    public ChapterResponse updateChapter(Long id, ChapterRequest request) {

        Chapter chapter = chapterRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Không tìm thấy chapter"));

        Manga manga = mangaRepository.findById(request.getMangaId())
                .orElseThrow(() ->
                        new RuntimeException("Không tìm thấy truyện"));

        chapter.setTitle(request.getTitle());
        chapter.setChapterNumber(request.getChapterNumber());
        chapter.setContentImage(request.getContentImage());
        chapter.setManga(manga);

        chapter = chapterRepository.save(chapter);

        return chapterMapper.toResponse(chapter);
    }

    public void deleteChapter(Long id) {

        if (!chapterRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy chapter");
        }

        chapterRepository.deleteById(id);
    }
}