package com.mercadolibre.calculadoradecalorias.service;

import com.mercadolibre.calculadoradecalorias.dto.response.AlimentoDTO;
import com.mercadolibre.calculadoradecalorias.dto.response.PlatoDTO;
import com.mercadolibre.calculadoradecalorias.entity.Alimento;
import com.mercadolibre.calculadoradecalorias.entity.Plato;
import com.mercadolibre.calculadoradecalorias.repository.PlatoRepositoryImp;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PlatoServiceImp{

    PlatoRepositoryImp platoRepo;

    public PlatoServiceImp (PlatoRepositoryImp platoRepo){
        this.platoRepo = platoRepo;
    }

    public PlatoDTO getByName (String name) {
        ObjectMapper mapper = new ObjectMapper();
        Plato plato = platoRepo.getByName(name);
        int caloriasTotales = 0;
        Alimento alimento = new Alimento("", 0);
        List<AlimentoDTO> alimentosDTO = new ArrayList<>();
        for (int i = 0; i < plato.getIngredients().size(); i++) {
            for (Map.Entry<Alimento, Integer> pair : plato.getIngredients().get(i).entrySet()) {
                if (pair.getKey().getCalories() > alimento.getCalories()) alimento = pair.getKey();
                caloriasTotales += pair.getKey().getCalories() * pair.getValue();
                alimentosDTO.add(new AlimentoDTO(pair.getKey().getName(), pair.getKey().getCalories() * pair.getValue()));
            }
        }
        return new PlatoDTO(caloriasTotales, alimentosDTO, new AlimentoDTO(alimento.getName(), alimento.getCalories()));
    }
}