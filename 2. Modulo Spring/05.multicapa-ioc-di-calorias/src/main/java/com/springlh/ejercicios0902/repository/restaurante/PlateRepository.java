package com.springlh.ejercicios0902.repository.restaurante;

import com.springlh.ejercicios0902.model.restaurante.Plate;

import java.util.List;
import java.util.Optional;

public interface PlateRepository {
    List<Plate> findAll();
    Optional<Plate> findByName(String name);
    Optional<Plate> findByNameAndWeight(String name, Integer weight);
}
