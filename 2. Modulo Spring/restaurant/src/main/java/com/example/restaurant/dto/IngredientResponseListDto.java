package com.example.restaurant.dto;

import com.example.restaurant.model.Ingredient;

import java.util.List;

public record IngredientResponseListDto(
    Integer calories,
    List<IngredientResponseDto> ingredients,
    IngredientResponseDto ingredient
) {
}
