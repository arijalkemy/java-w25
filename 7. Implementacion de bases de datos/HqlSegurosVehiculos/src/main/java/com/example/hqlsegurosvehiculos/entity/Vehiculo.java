package com.example.hqlsegurosvehiculos.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column
    String patente;
    @Column
    String marca;
    @Column
    String modelo;
    @Column
    Integer año_fabricacion;
    @Column
    Integer cant_ruedas;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "siniestro_id")
    private Set<Siniestro> siniestros;
}
