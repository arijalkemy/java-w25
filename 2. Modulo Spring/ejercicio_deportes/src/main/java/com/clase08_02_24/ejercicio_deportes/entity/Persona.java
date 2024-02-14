package com.clase08_02_24.ejercicio_deportes.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Persona {
    private String nombre;
    private String apellido;
    private Integer edad;
}
