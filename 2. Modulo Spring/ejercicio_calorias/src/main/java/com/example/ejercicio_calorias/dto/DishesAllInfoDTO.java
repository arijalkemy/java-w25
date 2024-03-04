package com.example.ejercicio_calorias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DishesAllInfoDTO {
    private int calories;
    private List<DishIngredientDTO> ingredients;

    @Override
    public String toString() {
        String res = "Total calorias: "+ calories+ "\nIngredientes";
        for(DishIngredientDTO ingredient : ingredients) {
            res = ingredient.getName() + "Calorias: "+ ingredient.getCalories();
        }
        return res;
    }
}
