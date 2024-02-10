package star_wars.service;

import org.springframework.stereotype.Service;
import star_wars.dto.PersonajeDTO;
import star_wars.entity.Personaje;
import star_wars.repository.IPersonajeRepo;
import star_wars.repository.PersonajeRepoImpl;

import java.util.List;

@Service
public class PersonajeServiceImpl implements IPersonajeService {

    private IPersonajeRepo personajeRepo;

    public PersonajeServiceImpl(PersonajeRepoImpl personajeRepo) {
        this.personajeRepo = personajeRepo;
    }

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

        return personajeRepo.getPersonajes().stream()
                .filter(p -> p.getName().contains(name))
                .map(pF -> getPersonajeDTO(pF))
                .toList();
    }
}
