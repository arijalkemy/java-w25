package com.clase08_02_24.ejercicio_deportes.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Deporte {
    String nombre;
    int nivel;
    List<Persona> personasInscriptas;
}
