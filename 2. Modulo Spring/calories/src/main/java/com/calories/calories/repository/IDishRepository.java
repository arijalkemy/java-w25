package com.calories.calories.repository;

import com.calories.calories.entity.Dish;

import java.util.ArrayList;

public interface IDishRepository {
    void addDish(Dish dish);
    ArrayList<Dish> getAll();
    Dish getDishByName(String name, int grams);
}
