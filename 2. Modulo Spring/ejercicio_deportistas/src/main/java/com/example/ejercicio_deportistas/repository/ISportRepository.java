package com.example.ejercicio_deportistas.repository;

import com.example.ejercicio_deportistas.entity.Sport;

import java.util.List;
import java.util.Optional;

public interface ISportRepository {
    List<Sport> findAll();

    Optional<Sport> findByName(String name);
}
