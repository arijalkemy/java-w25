package com.bootcamp.hql.model.entity;

import java.util.Set;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    private Integer annoFabricacion;
    private Integer ruedas;
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "vehiculo_id")
    private Set<Siniestro> siniestros;
}
