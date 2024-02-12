package com.example.ejercicio_calorias.service;

import com.example.ejercicio_calorias.dto.DishCaloriesDTO;
import com.example.ejercicio_calorias.dto.DishIngredientDTO;
import com.example.ejercicio_calorias.dto.DishIngredientsDTO;

public interface IDishService {
    DishCaloriesDTO calculateTotalCalories(String name, int weight);

    DishIngredientsDTO getIngredients(String name, int weight);

    DishIngredientDTO getIngredientWithMoreCalories(String name, int weight);
}
