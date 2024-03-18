package ejercicio.starwars.service;

import ejercicio.starwars.dto.PersonajeDTO;
import ejercicio.starwars.repository.PersonajeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeService {
    private final PersonajeRepository pjRepo;

    public PersonajeService(PersonajeRepository pjRepo){
        this.pjRepo = pjRepo;
    }

   public List<PersonajeDTO> getCharacter(String name){
        List<PersonajeDTO> personajeDTOList = pjRepo.mostrarPersonajes().stream()
                .filter(personaje -> personaje.getName().contains(name))
                .map(PersonajeDTO::new)
                .toList();

        if (personajeDTOList.isEmpty()){
            throw new RuntimeException("Se encontraron coincidencias con el nombre "+name);
        }
        return personajeDTOList;
   }
}
