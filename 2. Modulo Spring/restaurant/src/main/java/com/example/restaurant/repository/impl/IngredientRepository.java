package com.example.restaurant.repository.impl;

import com.example.restaurant.model.Ingredient;
import com.example.restaurant.repository.IIngredientRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
public class IngredientRepository implements IIngredientRepository {

    private List<Ingredient> ingredients;

    private final ResourceLoader resourceLoader;

    public IngredientRepository(ResourceLoader resourceLoader) throws IOException {
        this.resourceLoader = resourceLoader;
        loadData();
    }


    private void loadData() throws IOException {
        ingredients = new ObjectMapper().readValue(
                resourceLoader.getResource("classpath:food.json").getInputStream(),
                new TypeReference<List<Ingredient>>() {
                }
        );
    }

    @Override
    public List<Ingredient> findAll() {
        return ingredients;
    }
}
