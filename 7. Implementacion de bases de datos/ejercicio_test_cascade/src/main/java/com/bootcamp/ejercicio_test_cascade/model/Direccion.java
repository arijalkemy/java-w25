package com.bootcamp.ejercicio_test_cascade.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String calleYNumero;
    @OneToOne(mappedBy = "direccion")
    private Propietario propietario;

    public Direccion(String calleYNumero, Propietario propietario) {
        this.calleYNumero = calleYNumero;
        this.propietario = propietario;
    }
}
