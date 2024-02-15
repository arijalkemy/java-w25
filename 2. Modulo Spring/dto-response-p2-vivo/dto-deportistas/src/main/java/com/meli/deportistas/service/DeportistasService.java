package com.meli.deportistas.service;

import com.meli.deportistas.dto.response.DeportistasDTO;
import com.meli.deportistas.model.Deporte;
import com.meli.deportistas.model.Persona;
import com.meli.deportistas.repository.DeporteRepository;
import com.meli.deportistas.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DeportistasService {

    DeporteRepository deporteRepository;
    PersonaRepository personaRepository;

    @Autowired
    public DeportistasService(DeporteRepository deporteRepository,
                              PersonaRepository personaRepository) {
        this.deporteRepository = deporteRepository;
        this.personaRepository = personaRepository;
    }

    public List<Deporte> findSports(){
        return deporteRepository.findAll();
    }

    public Optional<Deporte> findSportByName(String name){
        return deporteRepository.findSportByName(name);
    }

    public List<DeportistasDTO> findSportsPersons(){
        List<Deporte> sports = findSports();
        List<Persona> persons = personaRepository.findAll();
        List<DeportistasDTO> sportPersons = new ArrayList<>();


        sportPersons.add(new DeportistasDTO(
               persons.get(0).getNombre()+" "+persons.get(0).getApellido(),
               sports.get(0).getNombre()
        ));

        sportPersons.add(new DeportistasDTO(
                persons.get(1).getNombre()+" "+persons.get(1).getApellido(),
                sports.get(0).getNombre()
        ));

        sportPersons.add(new DeportistasDTO(
                persons.get(2).getNombre()+" "+persons.get(2).getApellido(),
                sports.get(1).getNombre()
        ));

        sportPersons.add(new DeportistasDTO(
                persons.get(3).getNombre()+" "+persons.get(3).getApellido(),
                sports.get(1).getNombre()
        ));

        return sportPersons;
    }
}
