package com.example.demo.models.Manga;

import com.example.demo.models.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashSet;
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

    @Column(columnDefinition = "NVARCHAR(MAX)")
    private String description;
    private Boolean approved = false;
    private String coverImage;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    private Long views = 0L;

    private Integer chapterCount = 0;

    @Enumerated(EnumType.STRING)
    private MangaStatus status = MangaStatus.ONGOING;

    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToMany
    @JoinTable(
            name = "manga_categories",
            joinColumns = @JoinColumn(name = "manga_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories = new HashSet<>();
}