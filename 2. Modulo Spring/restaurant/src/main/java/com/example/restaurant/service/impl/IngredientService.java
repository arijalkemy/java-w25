package com.example.restaurant.service.impl;

import com.example.restaurant.dto.IngredientRequestDto;
import com.example.restaurant.dto.IngredientRequestListDto;
import com.example.restaurant.dto.IngredientResponseDto;
import com.example.restaurant.dto.IngredientResponseListDto;
import com.example.restaurant.model.Ingredient;
import com.example.restaurant.repository.IIngredientRepository;
import com.example.restaurant.service.IIngredientService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IngredientService implements IIngredientService {

    private final IIngredientRepository ingredientRepository;

    public IngredientService(IIngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public IngredientResponseListDto calculate(IngredientRequestListDto ingredientRequestListDto) {
        List<Ingredient> ingredients = this.ingredientRepository.findAll();
        List<IngredientResponseDto> ingredientResponseDtos = new ArrayList<>();
        for(IngredientRequestDto ingredientRequestDto: ingredientRequestListDto.dishes()){
            Map<String, IngredientResponseDto> ingredientResponseDtoMap =  new HashMap<>();
        }
    }
}
