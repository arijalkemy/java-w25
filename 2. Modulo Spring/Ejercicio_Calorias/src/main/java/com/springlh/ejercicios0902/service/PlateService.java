package com.springlh.ejercicios0902.service;

import com.springlh.ejercicios0902.dto.PlateCaloriesDTO;
import com.springlh.ejercicios0902.dto.PlateDTO;
import com.springlh.ejercicios0902.dto.PlateIngredientDTO;

import java.util.List;

public interface PlateService {
    //List<PlateDTO> findAll();

    PlateDTO findByNameAndWeight(String name, Integer weight);

    PlateCaloriesDTO findCaloriesByNameAndWeight(String name, Integer weight);

    PlateIngredientDTO findMostCaloriesIngredientByPlate(String name, Integer weight);

    List<PlateDTO> findPlatesByNames(List<String> names);
}
