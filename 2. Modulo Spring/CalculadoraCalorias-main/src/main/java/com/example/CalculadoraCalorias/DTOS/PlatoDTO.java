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
    private List<Ingrediente> ingredientes;
    private int caloriasTotales;
    private Ingrediente mostCaloriesIngredients;
    public PlatoDTO(Plato plato, int caloriasTotales, Ingrediente mostCaloriesIngredients){
        this.name = plato.getName();
        this.ingredientes= plato.getIngredientes();
        this.caloriasTotales = caloriasTotales;
        this.mostCaloriesIngredients = mostCaloriesIngredients;

    }
}

