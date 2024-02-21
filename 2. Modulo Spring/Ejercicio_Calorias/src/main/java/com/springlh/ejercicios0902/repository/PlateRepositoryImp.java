package com.springlh.ejercicios0902.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springlh.ejercicios0902.model.Plate;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class PlateRepositoryImp implements PlateRepository {

    private List<Plate> plateDatabase;

    public PlateRepositoryImp() {
        this.plateDatabase = loadDatabase();
    }

    private List<Plate> loadDatabase() {
        // cargar archivo con data json
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath: plates.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // herramientas para mapear
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Plate>> typeRef = new TypeReference<>() {
        };
        List<Plate> plates = null;
        try {
            // leer datos json y mapear a lista de ingredientes
            plates = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return plates;
    }

    @Override
    public List<Plate> findAll() {
        return plateDatabase;
    }

    @Override
    public Optional<Plate> findByName(String name) {
        return plateDatabase.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst();
    }

    @Override
    public Optional<Plate> findByNameAndWeight(String name, Integer weight) {
        return plateDatabase.stream()
                .filter(p -> p.getName().equals(name) && p.getWeight().equals(weight))
                .findFirst();
    }
}
