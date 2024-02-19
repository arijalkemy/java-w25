package com.bootcamp.ejercicio_calculadora.repository;


import com.bootcamp.ejercicio_calculadora.entity.Plato;

import java.util.List;

public interface IPlatoRepository {
    public List<Plato> getAll();
    public Plato getPlatoByName(String name);
}
