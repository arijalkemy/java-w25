package com.ejercicio.covid13.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SIntoma {
        private int codigo;
        private String nombre;
        private String nivelDeGravedad;
}
