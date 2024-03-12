package com.meli.seguros.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "Siniestros")
public class Siniestro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_siniestro")
    Long idSiniestro;
    @Column(name = "fecha_de_siniestro")
    LocalDate fechaDeSiniestro;
    @Column(name = "perdida_economica")
    Double perdidaEconomica;
    @ManyToOne
    Vehiculo vehiculo;
}
