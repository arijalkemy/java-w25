package com.meli.calculadoracalorias.repository;

import com.meli.calculadoracalorias.entity.Ingredient;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository {

    List<Ingredient> findAll();
    Optional<Ingredient> findByName(String name);
}
