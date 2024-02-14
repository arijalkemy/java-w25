package com.springlh.ejercicios0802.repository;

import com.springlh.ejercicios0802.model.Deporte;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class DeportesRepository {
    List<Deporte> deportes = Arrays.asList(
            new Deporte("Fútbol", "Básico"),
            new Deporte("Tenis", "Avanzado"),
            new Deporte("Rugby", "Básico"),
            new Deporte("Voley", "Básico"),
            new Deporte("Basket", "Básico"),
            new Deporte("Handbol", "Intermedio"),
            new Deporte("Natación", "Intermedio")
    );

    public List<Deporte> getDeportes() {
        return deportes;
    }

    public Optional<Deporte> getDeporteByName(String name) {

        if (name == null || name.trim().isEmpty()) {
            return Optional.empty();
        }

        for (Deporte d : deportes) {
            if (d.getNombre().equalsIgnoreCase(name.trim())) {
                return Optional.of(d);
            }
        }
        return Optional.empty();
    }
}
