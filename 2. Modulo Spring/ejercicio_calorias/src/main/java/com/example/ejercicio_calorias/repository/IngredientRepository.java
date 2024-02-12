package com.example.ejercicio_calorias.repository;

import com.example.ejercicio_calorias.model.Ingredient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Repository
public class IngredientRepository {
    private List<Ingredient> ingredients;

    public IngredientRepository(){
        ingredients = loadJson();
    }

    public Ingredient getByName(String name){
        return ingredients.stream()
                .filter(ingredient -> ingredient.getName().equals(name))
                .findAny()
                .orElse(new Ingredient("NA", 0));
    }

    private List<Ingredient> loadJson(){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Lee el archivo JSON
            File jsonFile = ResourceUtils.getFile("classpath:food.json");
            return objectMapper.readValue(jsonFile, new TypeReference<>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Ingredient getIngredientWithMaxCalories() {
        return ingredients.stream()
                .max(Comparator.comparing(Ingredient::getCalories))
                .orElse(new Ingredient("NA", 0));
    }
}
