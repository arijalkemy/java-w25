package com.miprimerproyecto.deportistas.services;

import com.miprimerproyecto.deportistas.dto.AthleteDTO;
import com.miprimerproyecto.deportistas.models.Deporte;
import com.miprimerproyecto.deportistas.models.Persona;

import java.util.ArrayList;
import java.util.List;

public class SportService {
    List<Deporte> sportsList = List.of(new Deporte("futbol","alto")
            ,new Deporte("sledding","medio")
            ,new Deporte("golf","bajo"));
    List<Persona> personList = List.of(new Persona("Tom","Brady", 46),
            new Persona("Lionel","Messi",36),
            new Persona("Tiger", "Woods",39));

    List<AthleteDTO> personDTOList = new ArrayList<>();

    public List<Persona> getAllPersons(){
        return personList;
    }

    public List<Deporte> getAllSports(){
        return sportsList;
    }

    public List<AthleteDTO> getDTOs(){
        for(int i=0;i<sportsList.size();i++){
            personDTOList.add(new AthleteDTO(personList.get(i).getNombre(), personList.get(i).getApellido(),sportsList.get(i).getNombre()));
        }
        return personDTOList;
    }


}
