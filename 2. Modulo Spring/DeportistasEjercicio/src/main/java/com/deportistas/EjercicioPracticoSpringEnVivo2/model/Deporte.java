package com.deportistas.EjercicioPracticoSpringEnVivo2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Deporte {
    private String nombre;
    private int nivel;
}
