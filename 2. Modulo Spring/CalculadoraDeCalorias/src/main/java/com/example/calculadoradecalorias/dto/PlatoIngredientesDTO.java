package com.example.calculadoradecalorias.dto;

import com.example.calculadoradecalorias.entity.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlatoIngredientesDTO {
    private List<Ingrediente> ingredients;
}
