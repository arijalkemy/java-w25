package com.example.ejercicio_lasPerlas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.Where;

@Getter
@Setter
@Entity
@SQLRestriction("ventaONo")
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long nro_identificatorio;
    private String nombre;
    private String material;
    private Integer peso;
    private String particularidad;
    private Boolean posee_piedra;
    private Boolean ventaONo;
}
