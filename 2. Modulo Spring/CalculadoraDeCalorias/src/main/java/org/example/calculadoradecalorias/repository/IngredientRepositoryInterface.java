package org.example.calculadoradecalorias.repository;

import org.example.calculadoradecalorias.dto.IngredientDto;

import java.util.Optional;

public interface IngredientRepositoryInterface {
    Optional<IngredientDto> findIngredientByName(String name);
}
