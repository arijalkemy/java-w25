package com.mercadolibre.calculadoracalorias.controller;

import com.mercadolibre.calculadoracalorias.dto.DishCaloriesDto;
import com.mercadolibre.calculadoracalorias.entity.Dish;
import com.mercadolibre.calculadoracalorias.repository.DishRepoImp;
import com.mercadolibre.calculadoracalorias.service.DisheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DishController {

    @Autowired
    DisheService disheService;

    @GetMapping("/menu")
    public ResponseEntity<List<Dish>> getDish(){
        return new ResponseEntity<>(disheService.getAllDishes(), HttpStatus.OK);
    }

    @GetMapping("/dishCalories")
    public  ResponseEntity<DishCaloriesDto> getCaloriesOfDish(@RequestParam String name){
        return new ResponseEntity<>(this.disheService.getCaloreisByDish(name),HttpStatus.OK );
    }

    @GetMapping("/dishInfo")
    public  ResponseEntity<Dish> getDish(@RequestParam String name){
        return new ResponseEntity<>(this.disheService.getDish(name),HttpStatus.OK );
    }

    @GetMapping("/dishHighCalories")
    public  ResponseEntity<DishCaloriesDto> getDishWithHighCalories(){
        return new ResponseEntity<>(this.disheService.getDishWhithHigherCalories(),HttpStatus.OK );
    }

}
