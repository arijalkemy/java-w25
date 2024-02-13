package com.mercadolibre.calculadoracalorias.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Portion {
    Ingredient ingredient;
    Integer  quantitY;
}
