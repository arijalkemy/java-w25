package com.example.CalculadoraCalorias.Services;

import com.example.CalculadoraCalorias.DTOS.PlatoDTO;
import com.example.CalculadoraCalorias.DTOS.PlatoRequestDTO;
import com.example.CalculadoraCalorias.Repositories.IngredientesRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class IngredienteService {
    @Autowired
    IngredientesRepositoryImp ingredientesRepositoryImp;

    public PlatoDTO getCalories(PlatoRequestDTO platoRequestDTO){
        PlatoDTO platoDTO = new PlatoDTO();
        Double caloriasSum = 0.0;
        Double mostcalories = 0.0;
        int cont = 0;
        String  ingredianteMostCalorie = "";
        for (Map.Entry<String,String> ingrediente: platoRequestDTO.getIngredientsPlate().entrySet()){
            String nombreIngrediente = ingrediente.getKey();
            int pesoIngrediente = Integer.parseInt(ingrediente.getValue());
            int calorias = ingredientesRepositoryImp.findByName(nombreIngrediente).getCalories();
            caloriasSum = caloriasSum +(((pesoIngrediente/100.0) * (calorias)));
            mostcalories =  (calorias > mostcalories)?calorias:mostcalories;
            ingredianteMostCalorie = (calorias >=  mostcalories)? nombreIngrediente:ingredianteMostCalorie;
        }

        platoDTO.setName(platoRequestDTO.getName());
        platoDTO.setIngredientesPlato(platoRequestDTO.getIngredientsPlate());
        platoDTO.setCaloriasTotales(caloriasSum);
        platoDTO.setMostCaloriesIngredients(ingredianteMostCalorie);
        return platoDTO;
    }}
