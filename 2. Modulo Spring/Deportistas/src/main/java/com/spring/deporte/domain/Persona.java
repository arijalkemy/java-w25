package com.spring.deporte.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Persona {
    String nombre;
    String apellido;
    int edad;
    List<Deporte> deportes = new ArrayList<>();

    public Persona(String apellido, String nombre, int edad){
        this.apellido = apellido;
        this.nombre = nombre;
        this.edad = edad;
    }

    public void agregarDeporte(Deporte deporte){
        this.deportes.add(deporte);
    }

}
