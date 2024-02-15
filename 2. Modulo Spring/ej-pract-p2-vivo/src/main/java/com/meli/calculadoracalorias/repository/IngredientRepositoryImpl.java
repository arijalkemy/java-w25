package com.meli.calculadoracalorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.calculadoracalorias.entity.Ingredient;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class IngredientRepositoryImpl implements IngredientRepository{
    List<Ingredient> ingredients = new ArrayList<>();
    public IngredientRepositoryImpl() {
        loadIngredients();
        System.out.println(ingredients);
    }

    private void loadIngredients(){
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingredient>> typeRef = new TypeReference<>() {};

        try {
            ingredients = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Ingredient> findAll() {
        return this.ingredients;
    }

    @Override
    public Optional<Ingredient> findByName(String name) {
        return this.ingredients.stream().filter(x -> x.getName().equalsIgnoreCase(name)).findFirst();
    }
}
