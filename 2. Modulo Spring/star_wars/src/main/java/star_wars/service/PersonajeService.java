package star_wars.service;

import star_wars.dto.PersonajeDTO;
import star_wars.entity.Personaje;

import java.util.List;

public interface PersonajeService {

    public PersonajeDTO getPersonajeDTO(Personaje p);
    public List<PersonajeDTO> findPersonajesByName(String name);
}
