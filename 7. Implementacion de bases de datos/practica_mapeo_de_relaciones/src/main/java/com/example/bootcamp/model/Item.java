package com.example.bootcamp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    // FORMA BIDIRECCIONAL
    @ManyToOne(cascade = CascadeType.PERSIST) // Muchos items asociados a 1 carrito
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;
}
