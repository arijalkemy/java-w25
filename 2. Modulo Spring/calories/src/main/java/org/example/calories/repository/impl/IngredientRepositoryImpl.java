package org.example.calories.repository.impl;

import org.example.calories.entity.Ingredient;
import org.example.calories.repository.common.IIngredientRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Repository
public class IngredientRepositoryImpl implements IIngredientRepository {
    private final String JSON_PATH = "database/food.json";
    private List<Ingredient> dataSource;

    public IngredientRepositoryImpl(){
        this.dataSource = List.of();
        var mapper = new ObjectMapper();
        try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream(this.JSON_PATH)){
            this.dataSource = mapper.readValue(inputStream, new TypeReference<List<Ingredient>>() {});
        }catch (IOException exception){
            throw new RuntimeException("Error Opening json data source",exception);
        }
    }
    @Override
    public List<Ingredient> getAll() {
        return this.dataSource;
    }
}
