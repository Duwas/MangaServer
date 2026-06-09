package com.example.demo.repository;

import com.example.demo.models.Chapter.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChapterRepository extends JpaRepository<Chapter, Long> {

    List<Chapter> findByMangaId(Long mangaId);
}