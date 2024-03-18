package com.example.ejemplo_jpa.model;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Siniestro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fechaSiniestro;
    private Double perdidaEconomica;
    @ManyToOne
    @JoinColumn(name = "vehiculo_id", referencedColumnName = "id")
    private Vehiculo vehiculo;

    public Siniestro(LocalDate fechaSiniestro, Double perdidaEconomica, Vehiculo vehiculo) {
    }
}
