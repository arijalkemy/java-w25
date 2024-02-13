package calorias.controller;

import calorias.dto.DishResponseDTO;
import calorias.service.DishService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class CaloriesController {

    private final DishService dishService;

    // Inyección de dependencia aquí.
    // Preguntar: por que se inyecta la interfase y no la clase de implementacion?
    public CaloriesController(DishService dishService){
        this.dishService = dishService;
    }

    // Usar como ejemplo http://localhost:8080/calorias/Hamburguesa%20al%20Roquefort
    // o tambien http://localhost:8080/calorias/costillas%20a%20la%20papa
    @GetMapping("/calorias/{dish}")
    public ResponseEntity<DishResponseDTO> caloriesCalculator(@PathVariable("dish") String dish) {
        System.out.println("Se solicita info del plato: " + dish);
        DishResponseDTO dishResponseDTO = dishService.getDishResponseDTO(dish);
        return new ResponseEntity<>(dishResponseDTO, HttpStatus.OK);
    }
}
