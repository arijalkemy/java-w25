package com.example.deportistas.dao;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Persona {

    private String nombre;
    private String apellido;
    private int edad;
    private Deporte deporte;

}
