package com.example.demo.models.Chapter;

import com.example.demo.models.Manga.Manga;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "chapters")
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "NVARCHAR(255)")
    private String title;

    private Integer chapterNumber;

    @ElementCollection
    @CollectionTable(
            name = "chapter_images",
            joinColumns = @JoinColumn(name = "chapter_id")
    )
    @Column(name = "image_url")
    private List<String> contentImages;

    private Long views = 0L;

    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "manga_id")
    private Manga manga;
}