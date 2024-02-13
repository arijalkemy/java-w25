package com.example.calorias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class DishDto {
    private List<FoodDto> ingredients;

    public List<FoodDto> getIngredients() {
        return ingredients;
    }
}
