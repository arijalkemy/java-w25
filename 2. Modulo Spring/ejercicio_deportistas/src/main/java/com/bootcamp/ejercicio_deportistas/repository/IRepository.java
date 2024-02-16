package com.bootcamp.ejercicio_deportistas.repository;

import com.bootcamp.ejercicio_deportistas.entity.Deporte;

import java.util.List;

public interface IRepository {
    public List<Deporte> getAllSports();
}
