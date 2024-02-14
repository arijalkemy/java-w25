package com.bootcamp.Calorias.repository;

import com.bootcamp.Calorias.entity.Ingrediente;
import com.bootcamp.Calorias.entity.Plato;
import java.util.Optional;

import java.util.List;

public interface ICaloriasRepository {
    List<Ingrediente> getIngredientes();

    Optional<Plato> getPlatoByName(String name);
}
