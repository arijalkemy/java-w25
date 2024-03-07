package com.bootcamp.Calorias.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredienteDTO {
    private String name;
    private int caloriasTotales;
}
