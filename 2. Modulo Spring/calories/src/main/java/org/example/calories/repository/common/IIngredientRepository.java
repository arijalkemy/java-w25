package org.example.calories.repository.common;

import org.example.calories.entity.Ingredient;

import java.util.List;

public interface IIngredientRepository {
    public List<Ingredient> getAll();
}
