package com.practicaEjerciciosp1Vivo.deportistas.repositories;

import com.practicaEjerciciosp1Vivo.deportistas.model.Deporte;
import com.practicaEjerciciosp1Vivo.deportistas.model.Persona;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RelacionRepository {
    Map<Persona, Deporte> personSport = new HashMap<>();

    public RelacionRepository(List<Persona> personas, List<Deporte> deportes) {
        for (int i = 0; i < personas.size(); i++) {
            this.personSport.put(personas.get(i),deportes.get(i));
        }
    }

    public Map<Persona, Deporte> getPersonSport() {
        return personSport;
    }
}
