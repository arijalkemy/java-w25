package com.example.deportes;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Persona {
    private String nombre;

    private String apellido;

    private int edad;

    private List<Deporte> deportes;
}