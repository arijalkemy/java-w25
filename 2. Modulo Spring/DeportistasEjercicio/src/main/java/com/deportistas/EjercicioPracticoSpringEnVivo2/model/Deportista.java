package com.deportistas.EjercicioPracticoSpringEnVivo2.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Deportista {

    private Persona persona;
    private Deporte deporte;
}
