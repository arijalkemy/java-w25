package com.bootcamp.ejercicio_vehiculos_siniestros.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Vehiculo {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private long id;
    private String patente;
    private String marca;
    private String modelo;
    private Integer anioFabricacion;
    private int cantidadDeRuedas;
    @OneToMany(mappedBy = "vehiculo")
    List<Siniestro> siniestros;
    }
