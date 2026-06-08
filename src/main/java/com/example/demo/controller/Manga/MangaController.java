package com.example.demo.controller.Manga;

import com.example.demo.dto.Manga.MangaRequest;
import com.example.demo.dto.Manga.MangaResponse;
import com.example.demo.services.MangaServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mangas")
@RequiredArgsConstructor
public class MangaController {

    private final MangaServices mangaServices;

    @PostMapping
    public MangaResponse createManga(
            @RequestBody MangaRequest request) {

        return mangaServices.createManga(request);
    }

    @GetMapping("/All")
    public List<MangaResponse> getAllMangas() {

        return mangaServices.getAllMangas();
    }

    @GetMapping("/{id}")
    public MangaResponse getMangaById(
            @PathVariable Long id) {

        return mangaServices.getMangaById(id);
    }
}