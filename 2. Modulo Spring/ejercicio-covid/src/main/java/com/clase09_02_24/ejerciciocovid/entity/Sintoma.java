package com.clase09_02_24.ejerciciocovid.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Sintoma {
    Integer codigo;
    String nombre;
    Integer nivel_de_gravedad;
}
