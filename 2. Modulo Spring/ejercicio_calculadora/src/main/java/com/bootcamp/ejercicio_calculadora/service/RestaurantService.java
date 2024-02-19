package com.bootcamp.ejercicio_calculadora.service;

import com.bootcamp.ejercicio_calculadora.dto.CaloriasDTO;
import com.bootcamp.ejercicio_calculadora.dto.IngredienteDTO;
import com.bootcamp.ejercicio_calculadora.entity.IngredientePlato;
import com.bootcamp.ejercicio_calculadora.repository.IIngredienteRepository;
import com.bootcamp.ejercicio_calculadora.repository.IPlatoRepository;
import com.bootcamp.ejercicio_calculadora.repository.IngredienteRepositoryImpl;
import com.bootcamp.ejercicio_calculadora.repository.PlatoRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RestaurantService {
    private IIngredienteRepository ingredientes;
    private IPlatoRepository platos;

    //Constructor para inicializar "ingredientes"
    public RestaurantService(IngredienteRepositoryImpl ingredientes, PlatoRepositoryImpl platos) {
        this.ingredientes = ingredientes;
        this.platos = platos;
    }

    public IngredienteDTO getMayorCalorias(String plato){
         IngredientePlato ingrediente = platos.getPlatoByName(plato)
                 .getIngredientes().stream()
                 .max(Comparator.comparing(ingredientePlato -> ingredientes.getIngredienteByName(ingredientePlato.getName()).getCalories()))
                 .orElseThrow(() -> new NoSuchElementException("No se encontró ningún ingrediente para el plato: " + plato));
         double calorias = (double) ingrediente.getGramos() * ingredientes.getIngredienteByName(ingrediente.getName()).getCalories()/100;
        return new IngredienteDTO(ingrediente.getName(), calorias);
    }

    public CaloriasDTO getCaloriasTotales(String plato){
        return new CaloriasDTO(
                this.platos.getPlatoByName(plato)
                        .getIngredientes().stream()
                        .mapToDouble(ingredientePlato -> (double) ingredientePlato.getGramos() * ingredientes.getIngredienteByName(ingredientePlato.getName()).getCalories()/100)
                        .sum()
        );
    }

    public List<IngredienteDTO> getListaIngredientes(String plato){
        List<IngredienteDTO> listaIngredienteDTO = new ArrayList<>();
        this.platos.getPlatoByName(plato)
                .getIngredientes().stream()
                .forEach(ingredientePlato -> listaIngredienteDTO.add(new IngredienteDTO(ingredientePlato.getName(), (double) ingredientePlato.getGramos() * ingredientes.getIngredienteByName(ingredientePlato.getName()).getCalories()/100)));
        return listaIngredienteDTO;
    }
}