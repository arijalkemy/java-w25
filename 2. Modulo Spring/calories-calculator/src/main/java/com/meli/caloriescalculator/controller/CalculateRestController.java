package com.meli.caloriescalculator.controller;

import com.meli.caloriescalculator.dto.DishDTO;
import com.meli.caloriescalculator.dto.DishResponseDTO;
import com.meli.caloriescalculator.service.DishService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CalculateRestController {
    private final DishService dishService;

    public CalculateRestController(DishService dishService) {
        this.dishService = dishService;
    }

    @PostMapping("/calculate")
    public DishResponseDTO calculate(@RequestBody DishDTO dish){
        return dishService.calculateCalories(dish);
    }

    @PostMapping("/calculateAll")
    public List<DishResponseDTO> calculate(@RequestBody List<DishDTO> dishes){
        return dishService.calculateAllCalories(dishes);
    }
}
