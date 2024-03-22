package com.example.ejercicio_deportistas.repository;

import com.example.ejercicio_deportistas.dto.PersonDTO;
import com.example.ejercicio_deportistas.entity.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepositoryImpl implements IPersonRepository{

    private static final List<Person> personList = new ArrayList<>(List.of(
            new Person("Pedro", "Sanchez", 35, "Voley"),
            new Person("juan", "Fernandez", 25, "Rugby"),
            new Person("Matias", "Insauralde", 25, "")));


    @Override
    public List<Person> findSportPersons() {
        return personList.stream().filter(person -> !person.getSportName().isBlank()).toList();
    }
}
