package com.bootcamp.ejercicio_movies_hql.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_at")
    private LocalDate createdAt;
    @Column(name = "updated_at")
    private LocalDate updatedAt;
    private String title;
    private double rating;
    private Integer awards;
    @Column(name="release_date")
    private LocalDate releaseDate;
    private Integer length;
    @OneToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    private Genre genre;
}
