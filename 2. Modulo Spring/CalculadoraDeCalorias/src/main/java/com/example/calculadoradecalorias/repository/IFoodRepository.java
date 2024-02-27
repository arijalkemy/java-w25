package com.example.calculadoradecalorias.repository;

import com.example.calculadoradecalorias.entity.Ingrediente;
import com.example.calculadoradecalorias.entity.Plato;

import java.util.List;

public interface IFoodRepository {
    List<Ingrediente> getIngredientes();

}
