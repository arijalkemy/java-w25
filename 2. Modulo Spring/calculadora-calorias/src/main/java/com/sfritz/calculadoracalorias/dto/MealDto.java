package com.sfritz.calculadoracalorias.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MealDto {
    private Integer totalCalories;
    private List<IngredientDto> ingredients;
    private IngredientDto highestCalorieIngredient;
}
