package com.example.calculadoradecalorias.repository;

import com.example.calculadoradecalorias.entity.Ingrediente;
import com.example.calculadoradecalorias.entity.Plato;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Repository
public class FoodRespositoryImp implements IFoodRepository{
    private List<Ingrediente> ingredientes;

    public FoodRespositoryImp(List<Ingrediente> ingredientes) {
        this.ingredientes = loadIngredients();
    }

    @Override
    public List<Ingrediente> getIngredientes() {
        return this.ingredientes;
    }

    private List<Ingrediente> loadIngredients(){
        File file = new File("classpath:food.json");
        ObjectMapper objectMapper = new ObjectMapper();
        List<Ingrediente> ingredientes = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
            ingredientes = objectMapper.readValue(file, new TypeReference<List<Ingrediente>>() {});
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
        }
        return ingredientes;
    }
}
