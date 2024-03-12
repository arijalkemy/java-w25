package com.implementacionbd.ejercicio.models;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehiculos")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "patente", nullable = false)
    private String patente;

    @Column(name = "marca", nullable = false)
    private String marca;

    @Column(name = "anyo_fabricacion", nullable = false)
    private LocalDate anyoFabricacion;

    @Column(name = "modelo", nullable = false)
    private String modelo;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehiculo_id")
    private List<Siniestro> siniestros;
}
