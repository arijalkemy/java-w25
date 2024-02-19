package com.bootcamp.ejercicio_calculadora.controller;

import com.bootcamp.ejercicio_calculadora.dto.CaloriasDTO;
import com.bootcamp.ejercicio_calculadora.dto.IngredienteDTO;
import com.bootcamp.ejercicio_calculadora.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class Controller {
    private RestaurantService restaurantService;

    @Autowired
    public Controller(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/caloriasTotales/{plato}")
    public ResponseEntity<CaloriasDTO> getCaloriasTotales(@PathVariable String plato){
        return new ResponseEntity<>(restaurantService.getCaloriasTotales(plato), HttpStatus.OK);
    }

    @GetMapping("/ingredienteMayorCalorias/{plato}")
    public ResponseEntity<IngredienteDTO> getMayorCalorias(@PathVariable String plato){
        return new ResponseEntity<>(restaurantService.getMayorCalorias(plato), HttpStatus.OK);
    }

    @GetMapping("/ingredientes/{plato}")
    public ResponseEntity<List<IngredienteDTO>> getListaIngredientes(@PathVariable String plato){
        return new ResponseEntity<>(restaurantService.getListaIngredientes(plato), HttpStatus.OK);
    }
}