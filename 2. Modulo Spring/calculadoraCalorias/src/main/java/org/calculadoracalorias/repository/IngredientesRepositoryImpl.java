package org.calculadoracalorias.repository;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.calculadoracalorias.entity.Ingrediente;

import java.io.File;
import java.io.IOException;
import java.util.List;


@org.springframework.stereotype.Repository
public class IngredientesRepositoryImpl implements IIngredientesRepository{
    List<Ingrediente> dbIngr;

    @Override
    public List<Ingrediente> getAll() {
        return dbIngr;
    }

    @Override
    public Ingrediente getByName(String nombre) {
        return dbIngr.stream()
                .filter(i -> i.getName().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }

    public IngredientesRepositoryImpl() {
        this.dbIngr = List.of(loadIngredientes());
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

}
