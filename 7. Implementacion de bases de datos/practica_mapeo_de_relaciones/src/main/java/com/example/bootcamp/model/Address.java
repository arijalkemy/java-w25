package com.example.bootcamp.model;

import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "address")
    // mappedBy: Indica que del lado de user el atributo address es quien establece la relacion
    // Solo se agrega si se quiere que la relación sea bidireccional
    private User user;
}
