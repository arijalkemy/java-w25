package com.practicaEjerciciosp1Vivo.deportistas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
}
