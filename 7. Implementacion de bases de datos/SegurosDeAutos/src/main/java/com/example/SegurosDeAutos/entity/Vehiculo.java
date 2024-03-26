package com.example.SegurosDeAutos.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "vehiculos")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    private Integer anioFabricacion;
    private Integer cantRuedas;

    @OneToMany(mappedBy = "vehiculoDenunciado", cascade = CascadeType.ALL)
    private List<Siniestro> siniestros;

}
