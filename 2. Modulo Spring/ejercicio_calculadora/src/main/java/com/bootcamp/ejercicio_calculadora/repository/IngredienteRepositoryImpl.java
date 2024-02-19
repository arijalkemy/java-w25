package com.bootcamp.ejercicio_calculadora.repository;

import com.bootcamp.ejercicio_calculadora.entity.Ingrediente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Repository
public class IngredienteRepositoryImpl implements IIngredienteRepository{

        private List<Ingrediente> ingredientes;

        public IngredienteRepositoryImpl(){
            loadList();
        }

        //Carga JSON
        private void loadList(){
            ObjectMapper mapper = new ObjectMapper();
            File jsonFile = null;
            try{
                jsonFile = ResourceUtils.getFile("classpath:food.json");
                this.ingredientes = mapper.readValue(jsonFile, new TypeReference<List<Ingrediente>>() {});
            } catch (IOException exception){
                System.out.println("No existe el archivo: " + exception.getMessage());
            }
        }

        //Métodos
        public List<Ingrediente> getAll(){
            return this.ingredientes;
        }
        public Ingrediente getIngredienteByName (String name){
            Ingrediente ingrediente = this.ingredientes.stream()
                    .filter(i -> i.getName().equalsIgnoreCase(name))
                    .findAny()
                    .orElseThrow(() -> new IllegalArgumentException("No se encontró el ingrediente por nombre: " + name));
            return ingrediente;
        }
}
