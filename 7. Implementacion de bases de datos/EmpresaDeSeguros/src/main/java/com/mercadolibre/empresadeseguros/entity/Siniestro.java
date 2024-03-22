package com.mercadolibre.empresadeseguros.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Siniestro {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_siniestro")
    private Long idSiniestro;
    private LocalDate fechaDeSiniestro;
    private Double perdidaEconomica;
    @ManyToOne @JoinColumn(name = "idVehiculo",nullable = false)
    private Vehiculo vehiculo;
}
