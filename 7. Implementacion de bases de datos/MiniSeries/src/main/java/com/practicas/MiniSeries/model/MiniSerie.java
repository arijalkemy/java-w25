package com.practicas.MiniSeries.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "miniserie")
public class MiniSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    Double rating;
    @Column(name = "amount_of_awards")
    int amountOfAwards;
}
