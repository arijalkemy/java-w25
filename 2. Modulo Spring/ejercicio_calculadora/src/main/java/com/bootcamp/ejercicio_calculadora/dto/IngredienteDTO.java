package com.bootcamp.ejercicio_calculadora.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IngredienteDTO {
    private String name;
    private double calories;
}
