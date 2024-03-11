package com.implementacionbasedatos.ejercicio1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jewerly")
public class Jewerly {
    @Id
    @Column(name = "nro_Identificatorio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nroIdentificatorio;

    private String nombre;

    private String material;

    @Column(name = "peso_Gramos")
    private Double pesoGramos;

    private String particularidad;

    @Column(name = "posee_piedra")
    private Boolean poseePiedra;

    @Column(name = "venta_o_no")
    private Boolean ventaONo;

}
