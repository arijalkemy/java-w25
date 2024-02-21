package com.spring.deporte.service;

import com.spring.deporte.entity.Persona;
import com.spring.deporte.dto.PersonaDTO;
import com.spring.deporte.dto.mapper.PersonaMapper;
import com.spring.deporte.repository.PersonaRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PersonaService {

    @Autowired
    PersonaRepository personaRepository;

    public List<Persona> todasLasPersonas(){
        return personaRepository.todasLasPersonas();
    }

    public List <PersonaDTO> deportistas(){
        return PersonaMapper.getInstances(personaRepository.deportistas());
    }
}
