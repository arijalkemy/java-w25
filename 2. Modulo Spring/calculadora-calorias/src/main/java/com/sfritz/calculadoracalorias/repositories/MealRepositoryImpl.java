package com.sfritz.calculadoracalorias.repositories;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sfritz.calculadoracalorias.entities.Ingredient;
import com.sfritz.calculadoracalorias.entities.Meal;

@Repository
public class MealRepositoryImpl implements MealRepository{

    private List<Ingredient> ingredients;
    private List<Meal> meals;

    public MealRepositoryImpl(){
        this.loadJson();
        this.loadMeals();
    }

    @Override
    public List<Meal> getMeals(String mealName) {
        return this.meals.stream().filter(m -> m.getName().equals(mealName)).toList();
    }
    
    private void loadJson(){
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFile = null;
        try {
            // Lee el archivo JSON
            jsonFile = ResourceUtils.getFile("classpath:food.json");
            this.ingredients = objectMapper.readValue(jsonFile, new TypeReference<List<Ingredient>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadMeals(){
        this.meals = Arrays.asList(
            new Meal("Pizza cuatro quesos",this.ingredients.stream().filter(i -> i.getName().equals("Harina de maíz")||i.getName().equals("Queso mozzarella")||i.getName().equals("Queso parmesano")||i.getName().equals("Queso gruyere")||i.getName().equals("Queso roquefort")).toList())
        );
    }
}
