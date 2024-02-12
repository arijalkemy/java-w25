package com.example.CalculadoraDeCalorias.dto.response;

import com.example.CalculadoraDeCalorias.entity.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CalculadoraDTO {
    private Double caloriasTotales;
    private List<String> listaDeIngredientes;
    private String ingredienteMasCalorico;
}
