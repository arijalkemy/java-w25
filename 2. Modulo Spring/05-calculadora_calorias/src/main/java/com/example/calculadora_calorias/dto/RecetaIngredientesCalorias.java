package com.example.calculadora_calorias.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RecetaIngredientesCalorias {

    String nombre;
    List<IngredientesCaloria> ingredientesCalorias;
    int totalCalorias;




}
