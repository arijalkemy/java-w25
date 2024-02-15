package com.meli.starwars.service;

import com.meli.starwars.dto.response.PersonajeDTO;
import com.meli.starwars.repository.PersonajeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeService {

    private PersonajeRepository personajeRepository;

    @Autowired
    public PersonajeService(PersonajeRepository personajeRepository) {
        this.personajeRepository = personajeRepository;
    }

    public List<PersonajeDTO> findByName(String name){
        ModelMapper modelMapper = new ModelMapper();

        return this.personajeRepository.findByName(name)
                .stream().map(x -> modelMapper.map(x,PersonajeDTO.class))
                .collect(Collectors.toList());
    }
}
