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
public class DishesRepositoryImp implements IDishedRepository {
    private List<Plato> dishes;

    public DishesRepositoryImp(List<Plato> dishes) {
        this.dishes = loadDishes();
    }

    @Override
    public List<Plato> getDishes() {
        return this.dishes;
    }

    private List<Plato> loadDishes(){
        File file = new File("classpath:dish.json");
        ObjectMapper objectMapper = new ObjectMapper();
        List<Plato> dishes = null;
        try {
            file = ResourceUtils.getFile("classpath:dish.json");
            dishes = objectMapper.readValue(file, new TypeReference<List<Plato>>() {});
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
        }
        return dishes;
    }

}
