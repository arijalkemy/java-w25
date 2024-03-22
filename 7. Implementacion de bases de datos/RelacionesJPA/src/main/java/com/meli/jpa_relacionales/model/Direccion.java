package com.meli.jpa_relacionales.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_direccion")
    private Long id_direccion;
    private String address;

    @OneToOne(mappedBy = "direccion")
    private Cliente cliente;
}
