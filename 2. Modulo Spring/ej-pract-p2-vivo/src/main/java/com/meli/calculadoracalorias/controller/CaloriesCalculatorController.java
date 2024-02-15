package com.meli.calculadoracalorias.controller;


import com.meli.calculadoracalorias.dto.response.DishDTO;
import com.meli.calculadoracalorias.service.CaloriesCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/calories-calculator")
public class CaloriesCalculatorController {

    private CaloriesCalculatorService caloriesCalculatorService;

    @Autowired
    public CaloriesCalculatorController(CaloriesCalculatorService caloriesCalculatorService) {
        this.caloriesCalculatorService = caloriesCalculatorService;
    }

    @GetMapping
    public ResponseEntity<DishDTO> getInfo(@RequestParam String name,
                                           @RequestParam Double weight){

        Optional<DishDTO> dishDTO = caloriesCalculatorService.getInfo(name,weight);
        if(dishDTO.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(dishDTO.get());
    }
}
