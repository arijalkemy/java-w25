package com.example.calculadoraCalorias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientesDTO {
    private String nombreIngrediente;
    private int calorias;
}
