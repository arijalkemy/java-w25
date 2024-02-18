package com.mercadolibre.calculadoradecalorias.repository;

import com.mercadolibre.calculadoradecalorias.entity.Alimento;

import java.util.List;

public interface IAlimentoRepository {
    public Alimento getAlimento(String name);
    public List<Alimento> getAll();
}
