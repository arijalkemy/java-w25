package com.bootcamp.ejercicio_calculadora.repository;


import com.bootcamp.ejercicio_calculadora.entity.Ingrediente;

import java.util.List;

public interface IIngredienteRepository {
    public List<Ingrediente> getAll();
    public Ingrediente getIngredienteByName(String name);
}
