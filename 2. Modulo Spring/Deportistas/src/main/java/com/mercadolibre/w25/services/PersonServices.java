package com.mercadolibre.w25.services;

import com.mercadolibre.w25.dto.PersonDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServices {
    private List<PersonDto> personDaos= new ArrayList<>();

    public List<PersonDto> getAllPerson() {
        return personDaos;
    }

    public void addPerson(PersonDto person){
        personDaos.add(person);
    }

    public PersonDto findByName(String name){
        return personDaos.stream().filter(x -> x.getName().equalsIgnoreCase(name) ).findFirst().orElse(null);
    }
}
