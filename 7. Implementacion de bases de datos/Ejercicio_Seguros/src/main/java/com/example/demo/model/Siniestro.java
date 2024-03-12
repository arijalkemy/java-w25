package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "siniestros")
public class Siniestro {

    @Id
    Long idSiniestro;
    LocalDate fechaSiniestro;
    Double perdidaEconomica;

    @ManyToOne
    @JoinColumn(name = "vehiculos_id", referencedColumnName = "id", nullable = false)
    Vehiculo vehiculo;
}
