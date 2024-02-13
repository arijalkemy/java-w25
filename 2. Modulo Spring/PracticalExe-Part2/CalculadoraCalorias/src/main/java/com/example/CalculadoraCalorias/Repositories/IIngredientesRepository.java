package com.example.CalculadoraCalorias.Repositories;

import com.example.CalculadoraCalorias.Models.Ingrediente;

public interface IIngredientesRepository {
    public void readIngredientes();
    public Ingrediente findByName(String name);
}
