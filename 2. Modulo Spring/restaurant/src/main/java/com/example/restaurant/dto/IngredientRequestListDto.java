package com.example.restaurant.dto;

import java.util.List;

public record IngredientRequestListDto(
        List<IngredientRequestDto> dishes
) {
}
