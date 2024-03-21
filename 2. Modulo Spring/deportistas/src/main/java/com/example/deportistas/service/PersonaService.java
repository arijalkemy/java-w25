package com.example.deportistas.service;

import com.example.deportistas.dto.response.DeportePersonaDTO;
import com.example.deportistas.model.Persona;
import com.example.deportistas.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {

    @Autowired
    PersonaRepository personaRepository;

    public List<DeportePersonaDTO> getPersonas() {
        List<Persona> personas = personaRepository.getPersonas();
        return personas.stream().map(p -> new DeportePersonaDTO(p.getNombre(), p.getApellido(), p.getDeporte().getNombre())).toList();
    }
}
