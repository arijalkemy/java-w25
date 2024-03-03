package PersonajeStarWars.service;

import PersonajeStarWars.dto.DtoPersonaje;
import PersonajeStarWars.entities.Personaje;
import PersonajeStarWars.repositories.PersonajeRepo;
import PersonajeStarWars.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeService {
    @Autowired
    PersonajeRepo personajeRepo;


    public List<DtoPersonaje> getDtoPersonajes(String nombre) {
        List<Personaje> personajesList=personajeRepo.getPersonajesRepo();
        List<DtoPersonaje> personajeByNombre = personajesList.stream().map(Mapper::mapPersonajeToDtoPersonaje).toList();
        return personajeByNombre.stream().filter( personaje -> personaje.getName().contains(nombre)).collect(Collectors.toList());

    }
}
