package main.repository;

import main.model.Personaje;

import java.util.List;

public interface IPersonajeRepository {
    List<Personaje> getAllCharacters();
}
