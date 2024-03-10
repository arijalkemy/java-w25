package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MiniSerie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    String nombre;
    Double rating;
    int amount_of_awards;

}
