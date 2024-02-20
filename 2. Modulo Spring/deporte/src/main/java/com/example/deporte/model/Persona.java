package com.example.deporte.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
}
