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
        System.out.println(ingredientesRepositoryImp.findByName("Leche"));
        return List.of(
                new Plato("Changua",List.of(
                        ingredientesRepositoryImp.findByName("Leche"),
                        ingredientesRepositoryImp.findByName("Cebolla"))),
                new Plato("Pizza",List.of(
                        ingredientesRepositoryImp.findByName("Aceitunas"),
                        ingredientesRepositoryImp.findByName("Cebolla"),
                        ingredientesRepositoryImp.findByName("Tomates"),
                        ingredientesRepositoryImp.findByName("Harina de trigo integral"))),
                new Plato("Empanadas",List.of(
                        ingredientesRepositoryImp.findByName("Pollo"),
                        ingredientesRepositoryImp.findByName("Cebolla"),
                        ingredientesRepositoryImp.findByName("Papas cocidas"),
                        ingredientesRepositoryImp.findByName("Harina de trigo integral"))),
                new Plato("Pastel de papa",List.of(
                        ingredientesRepositoryImp.findByName("Lomo embuchado"),
                        ingredientesRepositoryImp.findByName("Cebolla"),
                        ingredientesRepositoryImp.findByName("Papas cocidas"),
                        ingredientesRepositoryImp.findByName("Huevo entero"),
                        ingredientesRepositoryImp.findByName("Aceite de oliva"),
                        ingredientesRepositoryImp.findByName("Limón")))
        );
    }



}
