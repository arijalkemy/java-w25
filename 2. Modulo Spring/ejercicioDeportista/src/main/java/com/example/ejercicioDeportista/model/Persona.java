package com.example.ejercicioDeportista.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
}
