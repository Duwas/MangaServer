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

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChapterServices {

    private final ChapterRepository chapterRepository;
    private final MangaRepository mangaRepository;
    private final ChapterMapper chapterMapper;

    public ChapterResponse createChapter(ChapterRequest request) {

        Manga manga = mangaRepository.findById(request.getMangaId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy truyện"));

        Chapter chapter = new Chapter();

        chapter.setTitle(request.getTitle());
        chapter.setChapterNumber(request.getChapterNumber());
        chapter.setContentImages(request.getContentImages());
        chapter.setManga(manga);

        chapter = chapterRepository.save(chapter);

        manga.setChapterCount(manga.getChapterCount() + 1);
        mangaRepository.save(manga);

        return chapterMapper.toResponse(chapter);
    }

    public List<ChapterResponse> getAllChapters() {
        return chapterRepository.findAll()
                .stream()
                .map(chapterMapper::toResponse)
                .toList();
    }

    public List<ChapterResponse> getChaptersByManga(Long mangaId) {
        return chapterRepository.findByMangaId(mangaId)
                .stream()
                .map(chapterMapper::toResponse)
                .toList();
    }

    public ChapterResponse getChapterById(Long id) {
        Chapter chapter = chapterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy chapter"));

        chapter.setViews(chapter.getViews() + 1);
        chapterRepository.save(chapter);

        return chapterMapper.toResponse(chapter);
    }

    public ChapterResponse updateChapter(Long id, ChapterRequest request) {

        Chapter chapter = chapterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy chapter"));

        chapter.setTitle(request.getTitle());
        chapter.setChapterNumber(request.getChapterNumber());
        chapter.setContentImages(request.getContentImages());

        chapter = chapterRepository.save(chapter);

        return chapterMapper.toResponse(chapter);
    }

    public String deleteChapter(Long id) {

        Chapter chapter = chapterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy chapter"));

        Manga manga = chapter.getManga();

        chapterRepository.delete(chapter);

        if (manga != null && manga.getChapterCount() > 0) {
            manga.setChapterCount(manga.getChapterCount() - 1);
            mangaRepository.save(manga);
        }

        return "Xóa chapter có id " + id + " thành công";
    }
}