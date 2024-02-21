package com.springlh.ejercicios0902.service;

import com.springlh.ejercicios0902.dto.PlateCaloriesDTO;
import com.springlh.ejercicios0902.dto.PlateDTO;
import com.springlh.ejercicios0902.dto.PlateIngredientDTO;
import com.springlh.ejercicios0902.model.Ingredient;
import com.springlh.ejercicios0902.model.Plate;
import com.springlh.ejercicios0902.repository.PlateRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlateServiceImp implements PlateService {
    private final PlateRepository plateRepository;

    public PlateServiceImp(PlateRepository plateRepository) {
        this.plateRepository = plateRepository;
    }

    @Override
    public PlateDTO findByNameAndWeight(String name, Integer weight) {

        Optional<Plate> optionalPlate = plateRepository.findByNameAndWeight(name, weight);

        return optionalPlate.map(plate -> new PlateDTO(plate.getName(), plate.getIngredients()))
                .orElse(null);
    }

    @Override
    public PlateCaloriesDTO findCaloriesByNameAndWeight(String name, Integer weight) {

        Optional<Plate> optionalPlate = plateRepository.findByNameAndWeight(name, weight);

        return optionalPlate
                .map(plate -> new PlateCaloriesDTO(plate.getName(), plate.getTotal_calories()))
                .orElse(null);
    }

    @Override
    public PlateIngredientDTO findMostCaloriesIngredientByPlate(String name, Integer weight) {

        Optional<Plate> optionalPlate = plateRepository.findByNameAndWeight(name, weight);

        return optionalPlate
                .map(plate -> new PlateIngredientDTO(plate.getName(), plate.getIngredients()
                        .stream()
                        .sorted(Comparator.comparing(Ingredient::getCalories).reversed())
                        .findFirst()
                        .get()))
                .orElse(null);
    }

    @Override
    public List<PlateDTO> findPlatesByNames(List<String> names) {

        List<Plate> plates = plateRepository.findAll();

        plates = plates.stream()
                .filter(p -> names.contains(p.getName()))
                .collect(Collectors.toList());

        return plates.stream()
                .map(p -> new PlateDTO(p.getName(), p.getIngredients()))
                .collect(Collectors.toList());
    }

}
