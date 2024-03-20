package org.example.seguros.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "vehiculos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String patente;
    @Column
    private String marca;
    @Column
    private String modelo;
    @Column
    private Integer anioFabricacion;
    @Column
    private Integer cantidadRuedas;
    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL)
    private List<Siniestro> siniestroList;

    public Vehiculo(String patente, String marca, String modelo, Integer anioFabricacion, Integer cantidadRuedas, List<Siniestro> siniestroList) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;
        this.cantidadRuedas = cantidadRuedas;
        this.siniestroList = siniestroList;
    }
}
