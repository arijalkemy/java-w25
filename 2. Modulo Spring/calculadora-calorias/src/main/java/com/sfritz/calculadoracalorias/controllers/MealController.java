package com.sfritz.calculadoracalorias.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sfritz.calculadoracalorias.dto.MealDto;
import com.sfritz.calculadoracalorias.services.MealService;
import com.sfritz.calculadoracalorias.services.MealServiceImpl;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/meals")
public class MealController {

    private MealService service;

    public MealController(MealServiceImpl service){
        this.service = service;
    }

    @GetMapping("")
    public List<MealDto> getMeals(@RequestParam("name") String name, @RequestParam("peso") Integer peso) {
        return service.getMeals(name,peso);
    }
    
}
