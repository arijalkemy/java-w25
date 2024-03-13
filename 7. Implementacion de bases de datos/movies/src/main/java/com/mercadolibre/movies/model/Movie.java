package com.mercadolibre.movies.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "movies", schema = "movies_db")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "title", nullable = false, length = 500)
    private String title;

    @Column(name = "rating", nullable = false)
    private Double rating;

    @Column(name = "awards")
    private Integer awards;

    @Column(name = "release_date", nullable = false)
    private Instant releaseDate;

    @Column(name = "length")
    private Integer length;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @OneToMany(mappedBy = "movie")
    private Set<ActorMovie> actorMovies;

}