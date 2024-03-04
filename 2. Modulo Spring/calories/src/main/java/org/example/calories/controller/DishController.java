package org.example.calories.controller;

import org.example.calories.dto.dish.DishDTO;
import org.example.calories.dto.dish.DishRequestDTO;
import org.example.calories.service.common.IDishService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dish")
public class DishController {
    private IDishService dishService;
    public DishController(IDishService dishService){
        this.dishService = dishService;
    }

    @GetMapping
    public ResponseEntity<DishDTO> getDishByNameAndWeight(DishRequestDTO dto){
        return ResponseEntity.ok(this.dishService.getByNameAndWeight(dto.name(),dto.weight()));
    }
    @PostMapping("/list")
    public ResponseEntity<List<DishDTO>> getDishByNameAndWeight(@RequestBody List<DishRequestDTO> data){
        return ResponseEntity.ok(data.stream()
                .map(dish -> this.dishService.getByNameAndWeight(dish.name(),dish.weight())).toList());
    }

}
