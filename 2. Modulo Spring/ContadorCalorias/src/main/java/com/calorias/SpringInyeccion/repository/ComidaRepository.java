package com.calorias.SpringInyeccion.repository;

import com.calorias.SpringInyeccion.model.Ingrediente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ComidaRepository {

    public List<Ingrediente> obtenerIngredientes(){
        ObjectMapper mapper = new ObjectMapper();
        List<Ingrediente> ingredientes = new ArrayList<>();
        File jsonFile = null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:food.json");
            ingredientes = mapper.readValue(jsonFile, new TypeReference<List<Ingrediente>>() {});
        } catch (IOException ex ) {
            ex.printStackTrace();
        }
        return ingredientes;
    }
}
