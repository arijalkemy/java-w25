package com.example.excalorias.repository;

import com.example.excalorias.model.Plato;

import java.util.List;
public interface IPlatoRepository {
    List<Plato> findAllPlatos();

    Plato findPlatoByName(String name);
}
