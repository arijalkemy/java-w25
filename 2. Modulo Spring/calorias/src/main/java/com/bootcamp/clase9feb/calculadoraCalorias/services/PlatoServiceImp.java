package com.bootcamp.clase9feb.calculadoraCalorias.services;

import com.bootcamp.clase9feb.calculadoraCalorias.dto.response.AlimentoDTO;
import com.bootcamp.clase9feb.calculadoraCalorias.dto.response.PlatoDTO;
import com.bootcamp.clase9feb.calculadoraCalorias.entities.Alimento;
import com.bootcamp.clase9feb.calculadoraCalorias.entities.Plato;
import com.bootcamp.clase9feb.calculadoraCalorias.respositories.PlatoRepositoryImp;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
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
        int peso = 100;
        Alimento alimento = new Alimento("", 0);
        List<AlimentoDTO> alimentosDTO = new ArrayList<>();
        int peso = 0;
        for(int i=0; i< plato.getIngredients().size(); i++){
            for (Map.Entry<Alimento, Integer> pair : plato.getIngredients().get(i).entrySet()) {
                if(pair.getKey().getCalories() > alimento.getCalories()) alimento = pair.getKey();
                caloriasTotales += pair.getKey().getCalories() * pair.getValue();
                alimentosDTO.add(new AlimentoDTO(pair.getKey().getName(), pair.getKey().getCalories() * pair.getValue()));
            }
        }
        PlatoDTO platoDto = new PlatoDTO(caloriasTotales, alimentosDTO, new AlimentoDTO(alimento.getName(),
                                                                                        alimento.getCalories(), ));
        return platoDto;
    }
}
