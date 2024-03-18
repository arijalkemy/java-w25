package com.meli.seguros.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    @Column(name = "anio_fabricacion")
    private Integer anioFabricacion;
    @Column(name = "cantidad_ruedas")
    private Integer cantidadRuedas;

    @OneToMany
    @JoinColumn(name = "vehiculo_id")
    private List<Siniestro> siniestros;

}
