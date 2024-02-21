package com.sfritz.calculadoracalorias.services;

import java.util.List;

import com.sfritz.calculadoracalorias.dto.MealDto;

public interface MealService {
    List<MealDto> getMeals(String mealName, Integer calories);
}
