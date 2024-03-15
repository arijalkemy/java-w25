package com.example.showroom.model;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Clothe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long codigo;
    String nombre;
    String tipo;
    String marca;
    String color;
    String talle;
    Integer cantidad;
    Double precio;

    @OneToMany(mappedBy = "clothe")
    Set<Item> items;
}
