package org.example.calories.dto.ingredient;

import org.example.calories.entity.Ingredient;

public class IngredientMapper {
    public static IngredientDTO getIngredientDTO(Ingredient ingredient,short quantity){
        return new IngredientDTO(ingredient.getName(),ingredient.getCalories(),quantity);
    }
}
