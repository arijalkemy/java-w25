package com.example.CalculadoraDeCalorias.repository;

import com.example.CalculadoraDeCalorias.entity.Ingrediente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IngredienteRepositoryImp implements IIngredienteRepository {

    private List<Ingrediente> ingredientes;

    public IngredienteRepositoryImp() {
        loadJSON();
    }

    @Override
    public void loadJSON() {
        ObjectMapper mapper = new ObjectMapper();
        List<Ingrediente> ingredientes = new ArrayList<>();

        File jsonFile = null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:food.json");
            ingredientes = mapper.readValue(jsonFile, new TypeReference<>() {});
        } catch (IOException ex ) {
            ex.printStackTrace();
        }

        this.ingredientes = ingredientes;
    }

    @Override
    public List<Ingrediente> getIngredientes() {
        return this.ingredientes;
    }

    public Ingrediente getIngredienteByName(String nombre){
        return this.ingredientes.stream().filter(ing -> ing.getNombre().equals(nombre)).findFirst().get();
    }
}
