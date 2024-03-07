package com.example.ejercicio_calorias.dto;

import com.example.ejercicio_calorias.model.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DishIngredientsDTO {
    private List<DishIngredientDTO> ingredients;
}
