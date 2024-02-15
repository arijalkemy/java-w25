package com.meli.caloriescalculator.service;

import com.meli.caloriescalculator.dto.DishDTO;
import com.meli.caloriescalculator.dto.DishResponseDTO;

import java.util.List;

public interface DishService {
    DishResponseDTO calculateCalories(DishDTO dish);

    List<DishResponseDTO> calculateAllCalories(List<DishDTO> dishes);
}
