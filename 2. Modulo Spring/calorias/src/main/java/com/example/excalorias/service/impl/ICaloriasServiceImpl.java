package com.example.excalorias.service.impl;

import com.example.excalorias.model.Ingrediente;
import com.example.excalorias.model.Plato;
import com.example.excalorias.repository.IPlatoRepository;
import com.example.excalorias.service.ICaloriasService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class ICaloriasServiceImpl implements ICaloriasService {
    private final IPlatoRepository platoRepository;
    @Override
    public Map<String, Integer> getCalorias(List<String> nombresDePlatos){
        Map<String, Integer> caloriasPorPlato = new HashMap<>();
        Plato plato;
        for(String nombre : nombresDePlatos){
            plato = platoRepository.findPlatoByName(nombre);
            if(plato != null) {
                caloriasPorPlato.put(
                        nombre,
                        platoRepository.findPlatoByName(nombre)
                                .getIngredientes().stream()
                                .mapToInt(Ingrediente::getCalories)
                                .sum()
                );
            }
        }
        return caloriasPorPlato;
    }
    @Override
    public Map<String, List<Ingrediente>> getIngredientes(List<String> nombresDePlatos){
        Map<String, List<Ingrediente>> ingredientesPorPlato = new HashMap<>();
        Plato plato;
        for(String nombre : nombresDePlatos){
            plato = platoRepository.findPlatoByName(nombre);
            if(plato != null){
                ingredientesPorPlato.put(nombre, plato.getIngredientes());
            }
        }
        return ingredientesPorPlato;
    }

    @Override
    public Map<String, Ingrediente> getIngredienteMaxCalorias(List<String> nombresDePlatos){
        Map<String, Ingrediente> maxCaloriasPorPlato = new HashMap<>();
        Plato plato;
        for(String nombre : nombresDePlatos){
            plato = platoRepository.findPlatoByName(nombre);
            if(plato != null) {
                maxCaloriasPorPlato.put(
                        nombre,
                        platoRepository.findPlatoByName(nombre)
                                .getIngredientes().stream()
                                .max(Comparator.comparing(Ingrediente::getCalories))
                                .orElse(null)
                );
            }
        }
        return maxCaloriasPorPlato;
    }

}
