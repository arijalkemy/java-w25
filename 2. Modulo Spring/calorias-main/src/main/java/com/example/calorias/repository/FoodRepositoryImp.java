package com.example.calorias.repository;

import com.example.calorias.entity.Food;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FoodRepositoryImp implements IRepository<Food> {
    List<Food> dataRepository = new ArrayList<>();

    public FoodRepositoryImp() {
        loadData();
    }

    private void loadData() {
        ObjectMapper mapper  = new ObjectMapper();
        File jsonFile = null;

        try {
            jsonFile = ResourceUtils.getFile("classpath:food.json");
            this.dataRepository = mapper.readValue(jsonFile, new TypeReference<List<Food>>() { });
        }catch (IOException exception) {
            System.out.println("No existe el archivo: " + exception.getMessage());
        }
    }

    @Override
    public List<Food> findAll() {
        return dataRepository;
    }
}
