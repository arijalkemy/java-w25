package com.example.CalculadoraCalorias.Repositories;

import com.example.CalculadoraCalorias.Models.Plato;

import java.util.List;

public interface IPlatosRepository {

    public int cantidadTotalCalorias();
    public List<Plato> loadPlatos();


}
