package com.example.deportistas.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {

    String nombre;
    String apellido;
    Deporte deporte;
    int edad;
}
