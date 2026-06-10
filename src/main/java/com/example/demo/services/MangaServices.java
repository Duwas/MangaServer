package com.example.demo.services;

import com.example.demo.dto.Manga.MangaRequest;
import com.example.demo.dto.Manga.MangaResponse;
import com.example.demo.mapper.MangaMapper;
import com.example.demo.models.Manga.Category;
import com.example.demo.models.Manga.Manga;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.MangaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MangaServices {

    private final MangaRepository mangaRepository;
    private final CategoryRepository categoryRepository;
    private final MangaMapper mangaMapper;

    public MangaResponse createManga(MangaRequest request) {

        Manga manga = new Manga();

        manga.setTitle(request.getTitle());
        manga.setDescription(request.getDescription());
        manga.setCoverImage(request.getCoverImage());
        manga.setStatus(request.getStatus());

        Set<Category> categories = new HashSet<>(
                categoryRepository.findAllById(
                        request.getCategoryIds()
                )
        );

        manga.setCategories(categories);

        manga = mangaRepository.save(manga);

        return mangaMapper.toResponse(manga);
    }

    public List<MangaResponse> getAllMangas() {

        return mangaRepository.findAll()
                .stream()
                .map(mangaMapper::toResponse)
                .toList();
    }
    public List<MangaResponse> getApprovedMangas() {

        return mangaRepository.findByApprovedTrue()
                .stream()
                .map(mangaMapper::toResponse)
                .toList();
    }

    public MangaResponse getMangaById(Long id) {

        Manga manga = mangaRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Không tìm thấy truyện"));

        return mangaMapper.toResponse(manga);
    }
    public MangaResponse updateManga(Long id, MangaRequest request) {

        Manga manga = mangaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy truyện"));

        manga.setTitle(request.getTitle());
        manga.setDescription(request.getDescription());
        manga.setCoverImage(request.getCoverImage());
        manga.setStatus(request.getStatus());

        Set<Category> categories = new HashSet<>(
                categoryRepository.findAllById(request.getCategoryIds())
        );

        manga.setCategories(categories);

        manga = mangaRepository.save(manga);

        return mangaMapper.toResponse(manga);
    }

    public void deleteManga(Long id) {

        if (!mangaRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy truyện");
        }

        mangaRepository.deleteById(id);
    }
    public MangaResponse approveManga(Long id) {
        Manga manga = mangaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy truyện"));

        manga.setApproved(true);

        manga = mangaRepository.save(manga);

        return mangaMapper.toResponse(manga);
    }

    public MangaResponse rejectManga(Long id) {
        Manga manga = mangaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy truyện"));

        manga.setApproved(false);

        manga = mangaRepository.save(manga);

        return mangaMapper.toResponse(manga);
    }
}