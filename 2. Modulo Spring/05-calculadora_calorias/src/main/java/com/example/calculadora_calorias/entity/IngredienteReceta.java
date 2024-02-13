package com.example.calculadora_calorias.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class IngredienteReceta {

    String ingrediente;
    int porciones;

}
