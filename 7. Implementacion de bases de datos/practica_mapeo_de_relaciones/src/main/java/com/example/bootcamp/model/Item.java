package com.example.bootcamp.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // FORMA BIDIRECCIONAL
    @ManyToOne // Muchos items asociados a 1 carrito
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;
}
