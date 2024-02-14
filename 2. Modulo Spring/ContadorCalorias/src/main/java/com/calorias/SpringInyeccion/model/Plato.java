package com.calorias.SpringInyeccion.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class Plato {
    private String nombre;
    private List<String> ingredientes;
}
