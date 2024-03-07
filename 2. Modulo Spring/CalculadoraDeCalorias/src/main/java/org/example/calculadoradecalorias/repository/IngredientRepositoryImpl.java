package org.example.calculadoradecalorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.calculadoradecalorias.dto.IngredientDto;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class IngredientRepositoryImpl implements IngredientRepositoryInterface{

    private List<IngredientDto> database;

    public IngredientRepositoryImpl() {
        database = loadDataBase();
    }

    private List<IngredientDto> loadDataBase(){
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<IngredientDto>> typeRef = new TypeReference<>() {};
        List<IngredientDto> priceDTOS = null;
        try {
            priceDTOS = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return priceDTOS;
    }

    @Override
    public Optional<IngredientDto> findIngredientByName(String name) {
        return database.stream().filter(ingredient -> ingredient.getName().equalsIgnoreCase(name)).findFirst();
    }
}
