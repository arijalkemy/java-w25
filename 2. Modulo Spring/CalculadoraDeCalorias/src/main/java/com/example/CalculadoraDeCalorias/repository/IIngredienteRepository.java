package com.example.CalculadoraDeCalorias.repository;

import com.example.CalculadoraDeCalorias.entity.Ingrediente;
import lombok.Data;
import lombok.Getter;

import java.util.List;


public interface IIngredienteRepository {
    void loadJSON();
    List<Ingrediente> getIngredientes();
    Ingrediente getIngredienteByName(String nombre);


}
