package org.example.calculadoradecalorias.repository;

import org.example.calculadoradecalorias.dto.DishDto;
import org.example.calculadoradecalorias.dto.IngredientDto;

import java.util.List;
import java.util.Optional;

public interface DishRepositoryInterface {
    Optional<DishDto> findOneDishByName(String name);
}
