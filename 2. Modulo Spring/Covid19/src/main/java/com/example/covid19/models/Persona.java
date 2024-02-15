package com.example.covid19.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {

    private Long id;
    private String nombre;
    private String apellido;
    private int edad;
}
