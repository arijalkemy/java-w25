package com.meli.calculadoracalorias.dto.response;

import lombok.Data;

import java.util.Map;


@Data
public class DishDTO {
    private Double totalCalories;
    private Map<String,Double> ingredientsAndCalories;
    private String HighestCaloriesIngredient;
}
