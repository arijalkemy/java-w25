package main.service;

import lombok.AllArgsConstructor;
import main.dto.PersonajeDTO;
import main.repository.IPersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonajeServiceImpl implements IPersonajeService{

    IPersonajeRepository personajeRepository;

    public List<PersonajeDTO> searchCharacter (String character){
        return  personajeRepository.getAllCharacters().stream()
                .filter( p-> p.getName().contains(character))
                .map(pe -> new PersonajeDTO(pe.getName(), pe.getHeight(), pe.getMass(),
                        pe.getGender(), pe.getHomeworld(), pe.getSpecies()))
                .toList();
    }
}
