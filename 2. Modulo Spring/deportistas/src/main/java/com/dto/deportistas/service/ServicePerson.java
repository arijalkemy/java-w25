package com.dto.deportistas.service;

import com.dto.deportistas.dto.PersonaDTO;
import com.dto.deportistas.model.Persona;
import com.dto.deportistas.repository.GenericRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePerson {

    @Autowired
    GenericRepositoryImp personaRepositoryImp;

    /*
    public List<Persona> getPersonas(){
        return personaRepositoryImp.getLista();
    }*/
    public List<PersonaDTO> getPersonas(){
        List<Persona> personas = personaRepositoryImp.getLista();
        return personas.stream().map(p->{
            return new PersonaDTO(p.getNombre(),p.getApellido(),p.getDeporte().getNombre());
        }).toList();
    }
}
