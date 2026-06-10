package com.example.demo.models.Favorite;

import com.example.demo.models.Manga.Manga;
import com.example.demo.models.User;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "favorites")
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "manga_id")
    private Manga manga;
}