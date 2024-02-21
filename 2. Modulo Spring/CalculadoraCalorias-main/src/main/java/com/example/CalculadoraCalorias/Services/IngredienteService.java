package com.example.CalculadoraCalorias.Services;

import com.example.CalculadoraCalorias.DTOS.PlatoDTO;
import com.example.CalculadoraCalorias.DTOS.PlatoRequestDTO;
import com.example.CalculadoraCalorias.Models.Ingrediente;
import com.example.CalculadoraCalorias.Repositories.IngredientesRepositoryImp;
import com.example.CalculadoraCalorias.Repositories.PlatosRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredienteService {
    @Autowired
    IngredientesRepositoryImp ingredientesRepositoryImp;

    public PlatoDTO getCalories(PlatoRequestDTO platoRequestDTO){
        PlatoDTO platoDTO = new PlatoDTO();
        platoDTO.setIngredientes(ingredientesRepositoryImp.getIngredientes());
        return platoDTO;
    }
}
