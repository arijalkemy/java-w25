package com.example.calorias.controller;

import com.example.calorias.dto.FoodDto;
import com.example.calorias.entity.Food;
import com.example.calorias.service.DishService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.calorias.dto.DishDto;

@RestController
@RequestMapping("v1/api/dish")
public class DishController {

    DishService dishService = new DishService();
    // A
    @GetMapping("/calories-info")
    public ResponseEntity<Integer> getDishCaloriesInfo(@RequestParam String dish) {
        return new ResponseEntity<>(1, HttpStatus.OK);
    }


    // B
    @GetMapping("/")
    public ResponseEntity<DishDto> getDish(@RequestParam String dish) {
        DishDto dishDto = new DishDto(); // TODO
        return new ResponseEntity<>(DishDto, HttpStatus.OK);
    }

    // C
    @GetMapping("/max-calories")
    public ResponseEntity<FoodDto> getMaxCaloriesIngredient() {
        Food foodFound = dishService.getMaxCaloriesFood();
        FoodDto foodDto = new FoodDto(foodFound.getName(), foodFound.getCalories());
        return new ResponseEntity<>(foodDto, HttpStatus.OK);
    }
}
