package com.example.ejercicio_seguros.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "siniestros")
public class Siniestro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fecha;
    @Column(name= "perdida_economica")
    private Double perdidaEconomica;
    @ManyToOne
    @JoinColumn(name = "id_vehiculo_denunciado")
    private Vehiculo idVehiculoDenunciado;

    public Siniestro(LocalDate date, Double perdida){
        this.fecha =date;
        this.perdidaEconomica = perdida;
    }
}

