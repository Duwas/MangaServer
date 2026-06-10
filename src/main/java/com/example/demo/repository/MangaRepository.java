package com.example.demo.repository;

import com.example.demo.models.Manga.Manga;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MangaRepository extends JpaRepository<Manga, Long> {
    List<Manga> findByApprovedTrue();
}