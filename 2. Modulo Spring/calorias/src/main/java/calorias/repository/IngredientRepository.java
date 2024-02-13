package calorias.repository;

import calorias.dto.IngredientCaloriesDTO;

public interface IngredientRepository {

    IngredientCaloriesDTO findCaloriesForIngredient(String ingredientName);
}
