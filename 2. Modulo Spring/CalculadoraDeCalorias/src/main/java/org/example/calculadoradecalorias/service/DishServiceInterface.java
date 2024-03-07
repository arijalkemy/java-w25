package org.example.calculadoradecalorias.service;

import org.example.calculadoradecalorias.dto.DishDto;
import org.example.calculadoradecalorias.dto.DishIngredientsDto;
import org.example.calculadoradecalorias.dto.IngredientDto;

import java.util.List;

public interface DishServiceInterface {
    DishDto getOneDishByName(String name);
    IngredientDto ingredientWhitMoreCaloriesOf(DishDto dish);
    Integer calculateDishCalories(DishDto dish);
    DishIngredientsDto showDishIngredients(DishDto dish);
}
