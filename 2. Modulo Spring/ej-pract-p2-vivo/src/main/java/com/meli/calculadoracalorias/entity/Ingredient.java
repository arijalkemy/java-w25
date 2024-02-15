package com.meli.calculadoracalorias.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Ingredient {
    private String name;
    private Integer calories;
}
