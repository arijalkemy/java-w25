package com.example.calculadoraCalorias.repository;

import com.example.calculadoraCalorias.dto.IngredientesDTO;
import com.example.calculadoraCalorias.dto.PlatoDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PlatoRepositoryImpl{

    private List<PlatoDTO> platos;

    @PostConstruct
    public void cargarDatos(){
        try {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<PlatoDTO>> tipoReferencia = new TypeReference<List<PlatoDTO>>() {};
            InputStream inputStream = getClass().getResourceAsStream("/food.json");
            platos = mapper.readValue(inputStream, tipoReferencia);

        } catch (IOException e) {
            e.printStackTrace();
            platos = new ArrayList<>();
        }
    }

    public List<IngredientesDTO> ingredientes(String nombrePlato, int pesoEnGramo){
        return null;
    }
}
