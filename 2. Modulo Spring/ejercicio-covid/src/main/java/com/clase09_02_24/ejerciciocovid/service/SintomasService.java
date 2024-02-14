package com.clase09_02_24.ejerciciocovid.service;

import com.clase09_02_24.ejerciciocovid.dto.PersonaDeRiesgoDTO;
import com.clase09_02_24.ejerciciocovid.entity.Sintoma;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SintomasService {
    List<Sintoma> sintomasDB = new ArrayList<>(List.of(
            new Sintoma(1,"Tos",1),
            new Sintoma(2,"Frio",3),
            new Sintoma(3,"Cansancio",2)
    ));

    List<PersonaDeRiesgoDTO> personaDeRiesgoDTOList = new ArrayList<>(List.of(
            new PersonaDeRiesgoDTO("Claudio","Rodriguez",45,sintomasDB),
            new PersonaDeRiesgoDTO("Mariana","Pedro",67,sintomasDB),
            new PersonaDeRiesgoDTO("Mario","Amigo",45,sintomasDB),
            new PersonaDeRiesgoDTO("Lucas","Sanchez",70,sintomasDB)
    ));
    public List<Sintoma> getAllSintomas(){
        return sintomasDB;
    }

    public List<PersonaDeRiesgoDTO> getAllPersonaDeRiesgo(){
        return personaDeRiesgoDTOList;
    }
}
