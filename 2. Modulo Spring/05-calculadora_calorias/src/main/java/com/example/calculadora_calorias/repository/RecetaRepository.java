package com.example.calculadora_calorias.repository;

import com.example.calculadora_calorias.entity.IngredienteReceta;
import com.example.calculadora_calorias.entity.Receta;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
public class RecetaRepository {

    List<Receta> recetas;

    public RecetaRepository(List<Receta> recetas) {

        this.recetas = List.of(new Receta("Pizza",listIngredientesPizza()), new Receta("Sopa",listIngredientesSopa()));
    }


    public List<IngredienteReceta> listIngredientesPizza(){
        List<IngredienteReceta> ingredientes = new ArrayList<>();
        ingredientes.add(new IngredienteReceta("Aceitunas verdes",4));
        ingredientes.add(new IngredienteReceta("Alcachofas",1));
        ingredientes.add(new IngredienteReceta("Berenjena",3));
        ingredientes.add(new IngredienteReceta("Champiñón y otras setas",2));

        return ingredientes;
    }

    public List<IngredienteReceta> listIngredientesSopa(){
        List<IngredienteReceta> ingredientes = new ArrayList<>();
        ingredientes.add(new IngredienteReceta("Coliflor",4));
        ingredientes.add(new IngredienteReceta("Alcachofas",1));
        ingredientes.add(new IngredienteReceta("Calabaza",3));
        ingredientes.add(new IngredienteReceta("Champiñón y otras setas",2));

        return ingredientes;
    }
}
