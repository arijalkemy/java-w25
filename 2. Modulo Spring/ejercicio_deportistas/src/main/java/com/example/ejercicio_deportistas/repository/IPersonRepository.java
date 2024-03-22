package com.example.ejercicio_deportistas.repository;

import com.example.ejercicio_deportistas.dto.PersonDTO;
import com.example.ejercicio_deportistas.entity.Person;

import java.util.List;

public interface IPersonRepository {
    List<Person> findSportPersons();
}
