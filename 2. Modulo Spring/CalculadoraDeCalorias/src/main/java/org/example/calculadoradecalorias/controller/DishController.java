package org.example.calculadoradecalorias.controller;

import org.example.calculadoradecalorias.service.DishServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DishController {

    DishServiceImpl dishService = new DishServiceImpl();

    @GetMapping("totalCalories/{dishName}")
    public ResponseEntity<?> getTotalDishCalories(@PathVariable String dishName){
        return new ResponseEntity<>(dishService.calculateDishCalories(dishService.getOneDishByName(dishName)), HttpStatus.OK);
    }

    @GetMapping("dishIngredients/{dishName}")
    public ResponseEntity<?> getAllDishIngredients(@PathVariable String dishName){
        return new ResponseEntity<>(dishService.showDishIngredients(dishService.getOneDishByName(dishName)), HttpStatus.OK);
    }

    @GetMapping("dishBiggestIngredient/{dishName}")
    public ResponseEntity<?> getBiggestCaloriesIngredient(@PathVariable String dishName){
        return new ResponseEntity<>(dishService.ingredientWhitMoreCaloriesOf(dishService.getOneDishByName(dishName)), HttpStatus.OK);
    }
}
