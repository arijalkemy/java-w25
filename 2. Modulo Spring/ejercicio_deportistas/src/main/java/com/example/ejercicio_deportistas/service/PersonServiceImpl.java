package com.example.ejercicio_deportistas.service;

import com.example.ejercicio_deportistas.dto.SportPersonDTO;
import com.example.ejercicio_deportistas.entity.Person;
import com.example.ejercicio_deportistas.exception.NotFoundException;
import com.example.ejercicio_deportistas.repository.IPersonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements IPersonService{
    IPersonRepository personRepository;
    ModelMapper mapper;
    public PersonServiceImpl(IPersonRepository personRepository) {
        this.personRepository = personRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public List<SportPersonDTO> findSportPerson() {
        List<Person> personList = personRepository.findSportPersons();
        if (personList.isEmpty()) throw new NotFoundException("No se encontraron deportistas");
        return personList.stream().map(person -> this.mapper.map(person, SportPersonDTO.class)).toList();
    }
}
