package com.example.CalculadoraCalorias.Repositories;
import com.example.CalculadoraCalorias.Models.Ingrediente;
import com.example.CalculadoraCalorias.Models.Plato;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PlatosRepositoryImp implements IPlatosRepository{

    private  List<Plato> platoList = new ArrayList<>();

@Autowired
    private IngredientesRepositoryImp ingredientesRepositoryImp;




    @Override
    public int cantidadTotalCalorias() {
        return 0;
    }

    @Override
    public List<Plato> loadPlatos() {

        return List.of(
                new Plato("Changua",List.of(ingredientesRepositoryImp.findByName("Leche"), ingredientesRepositoryImp.findByName("Cebolla")))
        );
    }



}
