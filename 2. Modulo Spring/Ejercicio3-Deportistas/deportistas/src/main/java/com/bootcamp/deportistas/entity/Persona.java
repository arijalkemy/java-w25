package com.bootcamp.deportistas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Data
public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private List<Deporte> listaDeportes;

}
