package com.calories.calories.controller;

import com.calories.calories.dto.DishDTO;
import com.calories.calories.service.DishServiceImpl;
import com.calories.calories.service.IDishService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DishController {
    private final IDishService dishService;

    public DishController(IDishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping("/dish/{name}/{grams}")
    public ResponseEntity<DishDTO> getDishByName(@PathVariable String name, @PathVariable int grams) {
        return ResponseEntity.ok(this.dishService.getDishByName(name, grams));
    }
}
