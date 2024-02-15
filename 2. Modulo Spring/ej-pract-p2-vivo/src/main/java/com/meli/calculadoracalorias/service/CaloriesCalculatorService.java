package com.meli.calculadoracalorias.service;

import com.meli.calculadoracalorias.dto.response.DishDTO;

import java.util.Optional;

public interface CaloriesCalculatorService {

    Optional<DishDTO> getInfo(String name, Double weight);
}
