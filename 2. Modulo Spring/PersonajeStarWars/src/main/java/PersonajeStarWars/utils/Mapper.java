package PersonajeStarWars.utils;

import PersonajeStarWars.dto.DtoPersonaje;
import PersonajeStarWars.entities.Personaje;

public class Mapper {
    public static DtoPersonaje mapPersonajeToDtoPersonaje(Personaje personaje){
        return new DtoPersonaje(personaje.getName(),
                personaje.getHeight()!= null ? personaje.getHeight() : 0,
                personaje.getMass()!= null ? personaje.getMass() : 0,
                personaje.getGender(),
                personaje.getHomeworld(),
                personaje.getSpecies());
    }
}
