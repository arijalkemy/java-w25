package org.calculadoracalorias.repository;

import org.calculadoracalorias.entity.Ingrediente;

import java.util.List;

public interface IIngredientesRepository {
    public List<Ingrediente> getAll();

    public Ingrediente getByName(String nombre);
}
