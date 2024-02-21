package com.springlh.ejercicios0902.service.restaurante;

import com.springlh.ejercicios0902.dto.restaurante.PlateCaloriesDTO;
import com.springlh.ejercicios0902.dto.restaurante.PlateDTO;
import com.springlh.ejercicios0902.dto.restaurante.PlateIngredientDTO;
import com.springlh.ejercicios0902.model.restaurante.Plate;

import java.util.List;

public interface PlateService {
    //List<PlateDTO> findAll();

    PlateDTO findByNameAndWeight(String name, Integer weight);

    PlateCaloriesDTO findCaloriesByNameAndWeight(String name, Integer weight);

    PlateIngredientDTO findMostCaloriesIngredientByPlate(String name, Integer weight);

    List<PlateDTO> findPlatesByNames(List<String> names);
}
