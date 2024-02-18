package com.example.CalculadoraCalorias.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plato {
    private String name;
    private List<Ingrediente> ingredientesPlato;
}
