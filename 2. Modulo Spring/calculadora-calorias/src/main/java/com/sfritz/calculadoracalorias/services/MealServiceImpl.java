package com.sfritz.calculadoracalorias.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sfritz.calculadoracalorias.dto.IngredientDto;
import com.sfritz.calculadoracalorias.dto.MealDto;
import com.sfritz.calculadoracalorias.entities.Ingredient;
import com.sfritz.calculadoracalorias.entities.Meal;
import com.sfritz.calculadoracalorias.repositories.MealRepository;
import com.sfritz.calculadoracalorias.repositories.MealRepositoryImpl;

@Service
public class MealServiceImpl implements MealService{

    private MealRepository repository;

    public MealServiceImpl(MealRepositoryImpl repository){
        this.repository = repository;
    }

    @Override
    public List<MealDto> getMeals(String mealName, Integer peso) {
        List<Meal> meals = repository.getMeals(mealName);
        List<MealDto> mealDtos = new ArrayList<>();
        for(Meal m:meals){
            Ingredient highestCalorieIngredient = m.getIngredients().stream().max(Comparator.comparingInt(Ingredient::getCalories)).orElseThrow();
            List<IngredientDto> ingredientDtos = m.getIngredients().stream()
                .map(i -> new IngredientDto(i.getName(), i.getCalories()))
                .collect(Collectors.toList());
            mealDtos.add(
                new MealDto(
                    m.getIngredients().stream().mapToInt(Ingredient::getCalories).sum(),
                    ingredientDtos,
                    new IngredientDto(highestCalorieIngredient.getName(),highestCalorieIngredient.getCalories())
                    ));
        }
        return mealDtos;
    }

}
