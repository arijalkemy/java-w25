package com.springlh.ejercicios0902.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plate {

    private String name;
    private List<Ingredient> ingredients;
    private Integer weight;
    private Integer total_calories;

    public Plate(String name, List<Ingredient> ingredients, Integer weight) {
        this.name = name;
        this.ingredients = ingredients;
        this.weight = weight;
        this.total_calories = totalCalories();
    }

    private Integer totalCalories() {

        Integer total = 0;
        for (Ingredient i : ingredients) {
            total += i.getCalories();
        }

        return total;
    }
}
