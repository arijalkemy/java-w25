package com.calories.calories.service;

import com.calories.calories.dto.DishDTO;

public interface IDishService {
    void loadDishes();
    DishDTO getDishByName(String name, int grams);
}
