package com.calories.calories.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Dish {
    private String name;
    private int grams;
    private ArrayList<Ingredient> ingredients = new ArrayList<>();

    public int getCalories() {
        int calories = 0;
        for (Ingredient ingredientInDish : ingredients) {
            calories += ingredientInDish.getCalories();
        }
        return calories;
    }
}
