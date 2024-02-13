package com.example.CalculadoraCalorias.Repositories;

import com.example.CalculadoraCalorias.Models.Ingrediente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Data
@Repository
public class IngredientesRepositoryImp implements IIngredientesRepository {

    private List<Ingrediente> ingredientes = new ArrayList<>();
    public IngredientesRepositoryImp(){
        readIngredientes();
    }
    @Override
    public void readIngredientes() {
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFile = null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:food.json");
            ingredientes = objectMapper.readValue(jsonFile, new TypeReference<List<Ingrediente>>(){});
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public Ingrediente findByName(String name) {
        return ingredientes.stream()
                .filter(ingrediente -> ingrediente.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}
