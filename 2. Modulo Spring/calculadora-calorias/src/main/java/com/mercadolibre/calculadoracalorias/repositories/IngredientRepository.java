package com.mercadolibre.calculadoracalorias.repositories;

import com.mercadolibre.calculadoracalorias.dto.IngredientDTO;

public interface IngredientRepository {
  IngredientDTO findIngredientByName(String name);
}
