package com.bootcamp.ejercicio_consultas_HQL.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vehiculos")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patente;
    private String marca;
    private String modelo;
    @Column(name = "anyo_fabricacion")
    private Integer anyoFabricacion;
    @Column(name = "cantidad_ruedas")
    private Integer cantidadRuedas;
    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Siniestro> siniestros;
}
