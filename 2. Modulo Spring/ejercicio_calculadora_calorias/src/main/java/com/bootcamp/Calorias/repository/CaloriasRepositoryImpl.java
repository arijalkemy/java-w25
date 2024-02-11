package com.bootcamp.Calorias.repository;

import com.bootcamp.Calorias.entity.Ingrediente;
import com.bootcamp.Calorias.entity.IngredientexPlato;
import com.bootcamp.Calorias.entity.Plato;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CaloriasRepositoryImpl implements ICaloriasRepository{
    public List<Ingrediente> getIngredientes(){
        List<Ingrediente> ingredientes;
        try{
            byte[] jsonData = Files.readAllBytes(Paths.get("food.json"));
            ObjectMapper objectMapper = new ObjectMapper();
            ingredientes = objectMapper.readValue(jsonData, new TypeReference<List<Ingrediente>>() {
            });

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return ingredientes;

    }

    public List<Plato> getPlatos(){
        List<Ingrediente> ingredientes = getIngredientes();
        List<Plato> platos = new ArrayList<>();
        List<IngredientexPlato> ingredientexPlatoes =  new ArrayList<>();
        ingredientexPlatoes.add( new IngredientexPlato(ingredientes.get(0), 250));
        ingredientexPlatoes.add(new IngredientexPlato(ingredientes.get(1), 100));
        platos.add(new Plato(ingredientexPlatoes, "Pizza"));
        List<IngredientexPlato> ingredientes2 = new ArrayList<>();
        ingredientes2.add( new IngredientexPlato(ingredientes.get(3), 400));
        platos.add(new Plato(ingredientes2, "Caramelo"));
        return platos;
    }

    public Optional<Plato> getPlatoByName(String name){
        return getPlatos().stream().filter(plato -> plato.getNombre().equalsIgnoreCase(name)).findFirst();
    }
}
