package com.example.calculadoradecalorias.service;

import com.example.calculadoradecalorias.dto.PlatoCaloriasDTO;
import com.example.calculadoradecalorias.dto.PlatoIngredientesDTO;
import com.example.calculadoradecalorias.dto.PlatoMostCalories;

public interface IDishesService {
    PlatoCaloriasDTO getDishCalories(String plato);
    PlatoIngredientesDTO getDishIngredientsAndCalories(String plato);

    PlatoMostCalories getMostCaloriesIngredient(String plato);
}
