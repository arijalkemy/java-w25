package com.example.restaurant.repository;

import com.example.restaurant.model.Ingredient;

import java.util.List;

public interface IIngredientRepository {
    public List<Ingredient> findAll();
}
