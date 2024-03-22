package com.mercadolibre.empresadeseguros.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Vehiculo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehiculo")
    private Long idVehiculo;
    private String patente;
    private String marca;
    private String modelo;
    private Integer anioDeFabricacion;
    private Integer cantidadDeRuedas;
    @OneToMany(mappedBy = "vehiculo")
    private List<Siniestro> siniestros;
}
