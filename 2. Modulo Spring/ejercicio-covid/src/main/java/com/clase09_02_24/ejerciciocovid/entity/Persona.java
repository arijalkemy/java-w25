package com.clase09_02_24.ejerciciocovid.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Persona {
    Integer id;
    String nombre;
    String apellido;
    Integer edad;
}
