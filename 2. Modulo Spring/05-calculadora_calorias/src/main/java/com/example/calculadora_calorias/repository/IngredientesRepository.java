package com.example.calculadora_calorias.repository;

import com.example.calculadora_calorias.entity.Ingrediente;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Repository
@Data
public class IngredientesRepository {


    private List<Ingrediente> ingredientes;

    public IngredientesRepository() {

        this.ingredientes = List.of(loadIngredientes());
    }


    private Ingrediente[] loadIngredientes(){
        ObjectMapper mapperJSON  = new ObjectMapper();
        String ruta ="src/main/resources/food.json";

        try {
            return mapperJSON.readValue(new File(ruta), Ingrediente[].class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }


    public Optional<Ingrediente> findIngrediente(String ingrediente){

        return ingredientes.stream()
                .filter(ingrediente1 -> ingrediente1.getName().toLowerCase().equals(ingrediente.toLowerCase()))
                .findFirst();
    }

}
