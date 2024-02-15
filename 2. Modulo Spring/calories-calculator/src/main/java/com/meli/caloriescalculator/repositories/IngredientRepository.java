package com.meli.caloriescalculator.repositories;

import com.meli.caloriescalculator.dto.IngredientDTO;

public interface IngredientRepository {
    IngredientDTO findIngredientByName(String name);
}
