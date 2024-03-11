package com.example.configurando_jpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "mini_series")
public class MiniSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double rating;

    @Column(name = "amount_of_awards")
    private Integer amountOfAwards;

    public MiniSerie(Long id, String name, Double rating, Integer amountOfAwards) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.amountOfAwards = amountOfAwards;
    }

    public MiniSerie() {
    }

}
