package com.sfritz.calculadoracalorias.repositories;

import java.util.List;

import com.sfritz.calculadoracalorias.entities.Meal;

public interface MealRepository {
    List<Meal> getMeals(String mealName);
}
