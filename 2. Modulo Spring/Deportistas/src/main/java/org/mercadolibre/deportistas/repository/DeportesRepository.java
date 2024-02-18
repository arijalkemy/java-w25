package org.mercadolibre.deportistas.repository;

import org.mercadolibre.deportistas.model.Deporte;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class DeportesRepository {
    public static final List<Deporte> deportes = new ArrayList<>(
        Arrays.asList(
            new Deporte("F1", 10),
            new Deporte("Tenis", 9),
            new Deporte("Basket", 8)
        )
    );

    public List<Deporte> getAll() {
        return deportes;
    }

    public Optional<Deporte> getSportByName(String nombre) {
        return deportes
            .stream()
            .filter(deporte -> deporte.getNombre().equals(nombre))
            .findFirst();
    }
}