package com.mercadolibre.calculadoracalorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.calculadoracalorias.entity.Ingredient;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class IngredientRepoImp implements  IIngredientRepo{
    private List<Ingredient> ingredientList;


    public IngredientRepoImp(){
        this.ingredientList =new ArrayList<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            File jsonFile = null;
            jsonFile = ResourceUtils.getFile("classpath:food.json");
            ingredientList = mapper.readValue(jsonFile , new TypeReference<List<Ingredient>>(){}  );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Ingredient> getIngredientByName(String value) {
        return this.ingredientList.stream().filter( x-> x.getName().toLowerCase().contains(value.toLowerCase())).toList();
    }

    @Override
    public List<Ingredient> gerAll() {
        return this.ingredientList;
    }


    public List<Ingredient> gerRandomIngredient(Integer totol) {
        Random random = new Random();
        List<Ingredient> ramdonList = new ArrayList<>();

        for (int i=0; i< totol; i++){
            int randonIndex = random.nextInt(this.ingredientList.size()-1);
            ramdonList.add(this.ingredientList.get(randonIndex));
        }
        return ramdonList;
    }

}
