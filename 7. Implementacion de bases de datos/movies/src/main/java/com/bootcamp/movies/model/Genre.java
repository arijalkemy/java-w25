package com.bootcamp.movies.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "genres", indexes = {
        @Index(name = "genres_ranking_unique", columnList = "ranking", unique = true)
})
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int UNSIGNED not null")
    private Long id;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "ranking", columnDefinition = "int UNSIGNED not null")
    private Long ranking;

    @Column(name = "active", nullable = false)
    private Boolean active = false;

}