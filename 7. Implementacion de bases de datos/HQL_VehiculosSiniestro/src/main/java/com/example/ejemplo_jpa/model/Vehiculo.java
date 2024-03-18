package com.example.ejemplo_jpa.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
@Entity
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    @Column(name = "anio_de_fabricacion")
    private Integer anioDeFabricacion;
    @Column(name = "cantidad_de_ruedas")
    private Integer cantidadDeRuedas;
    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.PERSIST)
    Set<Siniestro> siniestros;
}
