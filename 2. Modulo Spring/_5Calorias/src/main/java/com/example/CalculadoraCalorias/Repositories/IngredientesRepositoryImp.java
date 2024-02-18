package com.example.CalculadoraCalorias.Repositories;

import com.example.CalculadoraCalorias.Models.Ingrediente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Data
@Repository
public class IngredientesRepositoryImp implements IIngredientesRepository {
    public IngredientesRepositoryImp(){

        readIngredientes("src/main/resources/food.json");
    }
    List<Ingrediente> ingredientes = new ArrayList<>();
    @Override
    public void readIngredientes(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFile = null;
        try {
            ingredientes = objectMapper.readValue(new File(filePath), new TypeReference<List<Ingrediente>>(){});
            } catch (IOException e) {
            e.printStackTrace();
            }
    }

    public Ingrediente findByName(String name) {
        return ingredientes.stream()
                .filter(food -> food.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}
