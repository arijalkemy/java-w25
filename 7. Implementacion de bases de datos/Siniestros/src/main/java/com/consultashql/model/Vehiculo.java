package com.consultashql.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    private Integer anio;
    private Integer cantidad_ruedas;

    @OneToMany(mappedBy = "vehiculo_denunciado", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<Siniestro> siniestros;
}
