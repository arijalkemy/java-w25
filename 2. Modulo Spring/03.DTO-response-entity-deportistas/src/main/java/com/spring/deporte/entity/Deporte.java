package com.spring.deporte.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Deporte {
    String nombre;
    String nivel;
    List<Persona> personas = new ArrayList<>();

    public Deporte (String nombre, String nivel){
        this.nivel = nivel;
        this.nombre = nombre;
    }

    public void agregarPersona(Persona persona){
        this.personas.add(persona);
    }

}
