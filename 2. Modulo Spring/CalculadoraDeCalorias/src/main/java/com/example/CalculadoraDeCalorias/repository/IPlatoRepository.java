package com.example.CalculadoraDeCalorias.repository;

import com.example.CalculadoraDeCalorias.entity.Plato;

import java.util.List;

public interface IPlatoRepository {
    Plato getPlatoByName(String nombre);
}
