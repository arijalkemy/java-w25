package com.example.ejercicio_calorias.controller;

import com.example.ejercicio_calorias.dto.DishCaloriesDTO;
import com.example.ejercicio_calorias.dto.DishIngredientDTO;
import com.example.ejercicio_calorias.dto.DishIngredientsDTO;
import com.example.ejercicio_calorias.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DishController {

    private final DishService dishService;

    @Autowired
    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping ("/dish/totalcalories/{name}/{weight}")
    public ResponseEntity<DishCaloriesDTO> getTotalCalories (@PathVariable String name, @PathVariable int weight){
        return new ResponseEntity<>(dishService.calculateTotalCalories(name, weight), HttpStatus.OK);
    }

    @GetMapping ("/dish/ingredients/{name}/{weight}")
    public ResponseEntity<DishIngredientsDTO> getIngredients (@PathVariable String name, @PathVariable int weight){
        return new ResponseEntity<>(dishService.getIngredients(name, weight), HttpStatus.OK);
    }

    @GetMapping ("/dish/ingredientwithmorecalories/{name}/{weight}")
    public ResponseEntity<DishIngredientDTO> getIngredientWithMoreCalories (@PathVariable String name, @PathVariable int weight){
        return new ResponseEntity<>(dishService.getIngredientWithMoreCalories(name, weight), HttpStatus.OK);
    }
}
