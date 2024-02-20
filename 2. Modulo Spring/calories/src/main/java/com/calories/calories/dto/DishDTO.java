package com.calories.calories.dto;

import com.calories.calories.entity.Ingredient;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DishDTO {
    private int calories;
    private ArrayList<Ingredient> ingredients;
    private Ingredient mostCaloriesIngredient;
}
