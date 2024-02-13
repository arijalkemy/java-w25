package com.example.CalculadoraCalorias.DTOS;

import com.example.CalculadoraCalorias.Models.Ingrediente;
import com.example.CalculadoraCalorias.Models.Plato;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlatoDTO {
    private String name;
    private List<IngredienteDTO> ingredientes;
    private double caloriasTotales;
    private IngredienteDTO mostCaloriesIngredients;
}

