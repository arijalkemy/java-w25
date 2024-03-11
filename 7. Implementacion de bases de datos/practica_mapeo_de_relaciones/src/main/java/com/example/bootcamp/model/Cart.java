package com.example.bootcamp.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // FORMA BIDIRECCIONAL
    @OneToMany(mappedBy = "cart")
    // MappedBy define el lado de referencia de la relación.
    // Esto quiere decir que en la tabla no se va a ver un campo items
    private Set<Item> items;
}
