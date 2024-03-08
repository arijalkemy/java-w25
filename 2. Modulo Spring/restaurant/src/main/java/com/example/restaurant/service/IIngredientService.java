package com.example.restaurant.service;

import com.example.restaurant.dto.IngredientRequestDto;
import com.example.restaurant.dto.IngredientRequestListDto;
import com.example.restaurant.dto.IngredientResponseListDto;

public interface IIngredientService {

    public IngredientResponseListDto calculate(IngredientRequestListDto ingredientRequestListDto);
}
