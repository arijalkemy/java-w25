package me.davidlake.proyectodeportistas.repository;

import me.davidlake.proyectodeportistas.model.Deporte;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DeporteRepository {
    public static final List<Deporte> deportes = List.of(
            new Deporte("Futbol",1),
            new Deporte("Tenis",2),
            new Deporte("Baloncesto",3),
            new Deporte("Rugby", 4)
    );

    public List<Deporte> getAll() {
        return deportes;
    }

    public Optional<Deporte> getPorNombre(String nombre){
        return deportes
                .stream()
                .filter(deporte -> deporte.getNombre().equals(nombre))
                .findFirst();
    }
}