package com.calories.calories.repository;

import com.calories.calories.entity.Ingredient;
import org.springframework.stereotype.Repository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;

@Repository
public class IngredientRepositoryImpl implements IIngredientRepository {
    private ArrayList<Ingredient> ingredients = new ArrayList<>();

    public IngredientRepositoryImpl() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ingredients = objectMapper.readValue(new File("/Users/jtoromejia/IdeaProjects/calories/src/main/resources/food.json"), new TypeReference<ArrayList<Ingredient>>() {});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Ingredient> getAll() {
        return ingredients;
    }

    @Override
    public Ingredient getIngredientByName(String name) {
        return ingredients.stream().filter(ingredient -> ingredient.getName().equals(name)).findFirst().orElse(null);
    }
}
