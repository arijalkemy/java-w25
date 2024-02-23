package com.ejercicio.covid13.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class Persona {
        private int id;
        private String nombre;
        private String apellido;
        private int edad;
        private List<SIntoma> sintomas;
}
