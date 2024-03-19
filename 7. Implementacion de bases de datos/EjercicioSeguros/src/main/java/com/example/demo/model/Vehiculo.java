package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "vehiculos")
public class Vehiculo {
    @Id
    Long id;
    String patente;
    String marca;
    String modelo;
    Integer anioDeFabricacion;
    Integer cantidadDeRuedas;

    @OneToMany(mappedBy = "vehiculo")
    Set<Siniestro> siniestros;

}
