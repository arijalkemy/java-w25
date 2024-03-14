package com.meli.covid19.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sintoma {
    private String codigo;
    private String nombre;
    private int nivelDeGravedad;

}
