package com.bootcamp.clase9feb.calculadoraCalorias.respositories;

import com.bootcamp.clase9feb.calculadoraCalorias.entities.Alimento;

import java.util.List;

public interface IAlimentoRepository {
    public Alimento getAlimento(String name);
    public List<Alimento> getAll();
}
