package com.example.restaurant.controller;

import com.example.restaurant.dto.IngredientRequestDto;
import com.example.restaurant.dto.IngredientRequestListDto;
import com.example.restaurant.dto.IngredientResponseListDto;
import com.example.restaurant.service.IIngredientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ingredients")
public class IngredientController {

    private final IIngredientService iIngredientService;

    public IngredientController(IIngredientService iIngredientService) {
        this.iIngredientService = iIngredientService;
    }

    @PostMapping
    public ResponseEntity<IngredientResponseListDto> calculate(@RequestBody IngredientRequestListDto ingredientRequestListDto){
        return new ResponseEntity<>(
                iIngredientService.calculate(ingredientRequestListDto),
                HttpStatus.OK
        );
    }
}
