package com.example.ejercicioDeportista.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Deporte {
    private String nombre;
    private int nivel;

}
