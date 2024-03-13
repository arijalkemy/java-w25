package com.example.ejemplo_jpa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    private Long id;
    @Column(name = "created_at")
    private LocalDate createdAt;
    @Column(name = "updated_at")
    private LocalDate updatedAt;
    @Column(name = "title")
    private String title;
    @Column(name = "rating", precision = 1)
    private Double rating;
    @Column(name = "awards")
    private Integer awards;
    @Column(name = "release_date")
    private LocalDate releaseDate;
    @Column(name = "length")
    private Integer length;
}
