package star_wars.service;

import org.springframework.stereotype.Service;
import star_wars.dto.PersonajeDTO;
import star_wars.entity.Personaje;
import star_wars.repository.PersonajesRepository;
import star_wars.repository.PersonajesRepositoryImpl;

import java.util.List;

@Service
public class PersonajeServiceImpl implements PersonajeService {

    private PersonajesRepository personajesRepo = new PersonajesRepositoryImpl();

    public PersonajeDTO getPersonajeDTO(Personaje p){
        PersonajeDTO personajeDTO = new PersonajeDTO();
        personajeDTO.setName(p.getName());
        personajeDTO.setHeight(p.getHeight());
        personajeDTO.setMass(p.getMass());
        personajeDTO.setGender(p.getGender());
        personajeDTO.setHomeworld(p.getHomeworld());
        personajeDTO.setSpecies(p.getSpecies());
        return personajeDTO;
    }
    @Override
    public List<PersonajeDTO> findPersonajesByName(String name) {

        return personajesRepo.getPersonajes().stream()
                .filter(p -> p.getName().contains(name))
                .map(pF -> getPersonajeDTO(pF))
                .toList();
    }
}
