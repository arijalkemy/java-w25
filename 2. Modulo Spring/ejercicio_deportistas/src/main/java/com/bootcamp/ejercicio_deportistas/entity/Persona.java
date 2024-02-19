package com.bootcamp.ejercicio_deportistas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Persona {
    private String nombre, apellido;
    private int edad;
    private Deporte deporte;
}
