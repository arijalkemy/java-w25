package calorias.repository;

import calorias.model.Ingredient;

import java.util.ArrayList;

public interface DishRepository {

    public ArrayList<Ingredient> getDishIngredients(String dishName);
}
