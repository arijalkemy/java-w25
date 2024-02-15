package main.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import main.dto.PersonajeDTO;
import main.entity.Personaje;
import main.repository.PersonajeRepository;

@Service
public class PersonajeService implements IPersonajeService {
    private PersonajeRepository personajeRepository;

    public PersonajeService() {
        this.personajeRepository = new PersonajeRepository();
    }

    @Override
    public List<PersonajeDTO> starWarsName(String name) {
        List<PersonajeDTO> list = new ArrayList<>();
        for (Personaje personaje : this.personajeRepository.getListaPersonajesStarWars()) {
            if (personaje.getName().toLowerCase().contains(name.toLowerCase())) {
                list.add(new PersonajeDTO(personaje));
            }
        }
        return list;
    }

}
