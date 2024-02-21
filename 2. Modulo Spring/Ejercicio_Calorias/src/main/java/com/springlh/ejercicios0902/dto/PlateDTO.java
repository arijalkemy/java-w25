package com.springlh.ejercicios0902.dto;

import com.springlh.ejercicios0902.model.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlateDTO {

    private String name;
    private List<Ingredient> ingredients;
    private Ingredient most_calories_ingredient;
    private Integer total_calories;

    public PlateDTO(String name, List<Ingredient> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
        this.most_calories_ingredient = mostCaloriesIngredient();
        this.total_calories = totalCalories();
    }

    private Ingredient mostCaloriesIngredient() {
        Ingredient mostCalories = new Ingredient("",0);

        for (Ingredient i : ingredients) {
            if (mostCalories.getCalories() < i.getCalories()) {
                mostCalories = i;
            }
        }

        return mostCalories;
    }

    private Integer totalCalories() {

        Integer total = 0;
        for (Ingredient i : ingredients) {
            total += i.getCalories();
        }

        return total;
    }
}