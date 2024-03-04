package org.example.calories.dto.dish;

import org.example.calories.dto.ingredient.IngredientDTO;
import org.example.calories.entity.Ingredient;

import java.util.List;

public record DishDTO(String name, float heatTotal, List<IngredientDTO> ingredients, Ingredient theMostHotIngredient) {
}
