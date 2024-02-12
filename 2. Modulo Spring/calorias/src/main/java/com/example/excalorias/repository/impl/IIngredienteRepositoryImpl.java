package com.example.excalorias.repository.impl;

import com.example.excalorias.model.Ingrediente;
import com.example.excalorias.repository.IIngredienteRepository;
import org.springframework.stereotype.Repository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;


import java.io.File;
import java.io.IOException;
import java.util.List;


@Repository
public class IIngredienteRepositoryImpl implements IIngredienteRepository {

    private List<Ingrediente> ingredientes;

    public IIngredienteRepositoryImpl() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            this.ingredientes = objectMapper.readValue(new File("/Users/sjaramillooc/IdeaProjects/calorias-ex/src/main/resources/food.json"), new TypeReference<List<Ingrediente>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Ingrediente> findAllIngredientes() {
        return this.ingredientes;
    }

}
