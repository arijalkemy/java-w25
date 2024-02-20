package com.calories.calories.repository;

import com.calories.calories.entity.Ingredient;

import java.util.ArrayList;

public interface IIngredientRepository {
    ArrayList<Ingredient> getAll();
    Ingredient getIngredientByName(String name);
}
