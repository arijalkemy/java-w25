package com.example.excalorias.repository;

import com.example.excalorias.model.Ingrediente;

import java.util.List;
public interface IIngredienteRepository {
    List<Ingrediente> findAllIngredientes();
}
