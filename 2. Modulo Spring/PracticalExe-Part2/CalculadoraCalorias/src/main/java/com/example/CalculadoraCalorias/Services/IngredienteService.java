package com.example.CalculadoraCalorias.Services;

import com.example.CalculadoraCalorias.DTOS.IngredienteDTO;
import com.example.CalculadoraCalorias.DTOS.PlatoDTO;
import com.example.CalculadoraCalorias.DTOS.PlatoRequestDTO;
import com.example.CalculadoraCalorias.Models.Ingrediente;
import com.example.CalculadoraCalorias.Models.Plato;
import com.example.CalculadoraCalorias.Repositories.IngredientesRepositoryImp;
import com.example.CalculadoraCalorias.Repositories.PlatosRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredienteService {
    @Autowired
    PlatosRepositoryImp platosRepositoryImp;

    public PlatoDTO getCalories(PlatoRequestDTO platoRequestDTO) {
        Plato plato = platosRepositoryImp.getPlatoList().stream()
                .filter(x -> x.getName().equalsIgnoreCase(platoRequestDTO.getName()))
                .findFirst().orElse(null);
        double calTotal = 0;
        IngredienteDTO maxIngrediente = null;
        int maxCalories = 0;
        List<IngredienteDTO> ingredienteDTOList = new ArrayList<>();
        double tasaMult = (double) platoRequestDTO.getWeight() / 100;
        for (Ingrediente ingrediente : plato.getIngredientes()) {
            IngredienteDTO ingredienteDTO = new IngredienteDTO(ingrediente.getName(), ingrediente.getCalories()*tasaMult);
            ingredienteDTOList.add(ingredienteDTO);
            calTotal += ingredienteDTO.getCalories();
            if (ingrediente.getCalories() > maxCalories) {
                maxCalories = ingrediente.getCalories();
                maxIngrediente = ingredienteDTO;
            }
        }
        return new PlatoDTO(plato.getName(), ingredienteDTOList, calTotal, maxIngrediente);
    }
}