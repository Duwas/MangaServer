package com.example.demo.models.Manga;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@Table(name = "mangas")
public class Manga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "NVARCHAR(255)")
    private String title;

    @Column(unique = true)
    private String slug;

    @Column(columnDefinition = "NVARCHAR(255)")
    private String alternativeTitle;

    @Column(columnDefinition = "NVARCHAR(MAX)")
    private String description;

    private String coverImage;

    private String bannerImage;

    @Column(columnDefinition = "NVARCHAR(100)")
    private String author;

    @Column(columnDefinition = "NVARCHAR(50)")
    private String country;

    private Integer chapterCount = 0;

    private Long views = 0L;

    private Double averageRating = 0.0;

    private Integer ratingCount = 0;

    @Enumerated(EnumType.STRING)
    private MangaStatus status = MangaStatus.ONGOING;

    private Boolean approved = false;

    private Boolean hot = false;

    private Boolean featured = false;

    private Boolean newManga = false;

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt = LocalDateTime.now();

    @ManyToMany
    @JoinTable(
            name = "manga_categories",
            joinColumns = @JoinColumn(name = "manga_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories;
}