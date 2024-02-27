package com.example.calculadoradecalorias.controller;

import com.example.calculadoradecalorias.dto.PlatoCaloriasDTO;
import com.example.calculadoradecalorias.dto.PlatoIngredientesDTO;
import com.example.calculadoradecalorias.dto.PlatoMostCalories;
import com.example.calculadoradecalorias.service.IDishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurant")
public class CalculadoraController {

    @Autowired
    IDishesService dishesService;

   @GetMapping("/dishes/{plato}")
   public ResponseEntity<PlatoCaloriasDTO> getCalories(@PathVariable String plato) {
        return ResponseEntity.ok(dishesService.getDishCalories(plato));
   }

   @GetMapping("/dishes/ingredients/{plato}")
    public ResponseEntity<PlatoIngredientesDTO> getIngredientsAndCalories(@PathVariable String plato) {
          return ResponseEntity.ok(dishesService.getDishIngredientsAndCalories(plato));
    }

   @GetMapping("/dishes/mostcalories/{plato}")
    public ResponseEntity<PlatoMostCalories> getMostCaloriesIngredient(@PathVariable String plato) {
          return ResponseEntity.ok(dishesService.getMostCaloriesIngredient(plato));
    }
}
