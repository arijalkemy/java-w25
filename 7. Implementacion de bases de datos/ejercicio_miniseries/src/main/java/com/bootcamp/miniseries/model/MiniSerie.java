package com.bootcamp.miniseries.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class MiniSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,  generator="native")
    private Long id;
    private String name;
    private Double rating;
    private Integer amount_of_awards;
}
