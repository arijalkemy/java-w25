package com.bootcamp.ejercicio_calculadora.repository;

import com.bootcamp.ejercicio_calculadora.entity.Plato;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Repository
public class PlatoRepositoryImpl implements IPlatoRepository {

    private List<Plato> platos;

    public PlatoRepositoryImpl(){
        loadPlatos();
    }

    //Carga JSON
    private void loadPlatos(){
        ObjectMapper mapper = new ObjectMapper();
        File jsonFile = null;
        try{
            jsonFile = ResourceUtils.getFile("classpath:dish.json");
            this.platos = mapper.readValue(jsonFile, new TypeReference<List<Plato>>() {});
        } catch (IOException exception){
            System.out.println("No existe el archivo: " + exception.getMessage());
        }
    }

    @Override
    public List<Plato> getAll(){
        return this.platos;
    }

    @Override
    public Plato getPlatoByName (String name){
        Plato plato = this.platos.stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No se encontró el plato por nombre: " + name));
        return plato;
    }
}
