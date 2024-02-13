package calorias.service;

import calorias.dto.DishResponseDTO;
import calorias.model.Dish;
import calorias.model.Ingredient;

import java.util.ArrayList;

public interface DishService {
    public double getCaloriesTotal(Dish dish);
    public Dish createDishObject(String dishName);
    public String getMostCaloricIngredient(Dish dish);
    public DishResponseDTO getDishResponseDTO(String dishName);

}
