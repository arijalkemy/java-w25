package org.bootcamp.starwars.repository;

import org.bootcamp.starwars.entity.Personaje;

import java.util.List;

public interface IPersonajeRepository {
    void leerPersonajesDesdeJson(String rutaArchivo);
}
