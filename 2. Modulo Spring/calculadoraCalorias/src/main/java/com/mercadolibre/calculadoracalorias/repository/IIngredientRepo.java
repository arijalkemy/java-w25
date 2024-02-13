package com.mercadolibre.calculadoracalorias.repository;

import com.mercadolibre.calculadoracalorias.entity.Ingredient;

import java.util.List;

public interface IIngredientRepo {
    List<Ingredient> getIngredientByName(String value);
    List<Ingredient> gerAll();
}
