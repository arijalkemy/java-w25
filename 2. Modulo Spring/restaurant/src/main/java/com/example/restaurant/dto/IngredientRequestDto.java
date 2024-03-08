package com.example.restaurant.dto;

import java.util.List;

public record IngredientRequestDto(
        String name,
        Double weight,
        List<String> ingredients
    ) {
}
