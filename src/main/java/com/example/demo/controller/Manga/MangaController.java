package com.example.demo.controller.Manga;

import com.example.demo.dto.Manga.MangaRequest;
import com.example.demo.dto.Manga.MangaResponse;
import com.example.demo.services.MangaServices;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mangas")
@RequiredArgsConstructor
public class MangaController {

    private final MangaServices mangaServices;

    @PostMapping
    @PreAuthorize("hasAnyRole('AUTHOR', 'ADMIN')")
    public MangaResponse createManga(@RequestBody MangaRequest request) {
        return mangaServices.createManga(request);
    }

    @GetMapping("/all")
    public List<MangaResponse> getAllMangas() {
        return mangaServices.getAllMangas();
    }

    @GetMapping("/approved")
    public List<MangaResponse> getApprovedMangas() {
        return mangaServices.getApprovedMangas();
    }

    @GetMapping("/{id}")
    public MangaResponse getMangaById(@PathVariable Long id) {
        return mangaServices.getMangaById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('AUTHOR', 'ADMIN')")
    public MangaResponse updateManga(
            @PathVariable Long id,
            @RequestBody MangaRequest request) {
        return mangaServices.updateManga(id, request);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteManga(@PathVariable Long id) {
        return mangaServices.deleteManga(id);
    }

    @PutMapping("/{id}/approve")
    @PreAuthorize("hasRole('ADMIN')")
    public MangaResponse approveManga(@PathVariable Long id) {
        return mangaServices.approveManga(id);
    }

    @PutMapping("/{id}/reject")
    @PreAuthorize("hasRole('ADMIN')")
    public MangaResponse rejectManga(@PathVariable Long id) {
        return mangaServices.rejectManga(id);
    }
}