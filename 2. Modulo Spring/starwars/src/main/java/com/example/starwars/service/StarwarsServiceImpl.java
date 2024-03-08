package com.example.starwars.service;

import com.example.starwars.dto.PersonajeDTO;
import com.example.starwars.repository.IPersonajeRepository;
import com.example.starwars.repository.PersonajeRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarwarsServiceImpl implements IStarwarsService{
    public List<PersonajeDTO> findByName(String word){
        IPersonajeRepository personajeRepository = new PersonajeRepositoryImpl();
        return personajeRepository.findByName(word).stream().map(PersonajeDTO::new).toList();
    }
}
