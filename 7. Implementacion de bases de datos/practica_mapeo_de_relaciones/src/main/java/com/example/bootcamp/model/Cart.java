package com.example.bootcamp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;


@Entity
@Data
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // FORMA BIDIRECCIONAL
    // MappedBy define el lado de referencia de la relación.
    // Esto quiere decir que en la tabla no se va a ver un campo items
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Item> items;
}


