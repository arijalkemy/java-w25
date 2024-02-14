package com.COVID19.COVID19.repository;

import com.COVID19.COVID19.model.Person;
import com.COVID19.COVID19.model.Symptom;

import java.util.Arrays;
import java.util.List;

public class PersonRepository {
    private List<Person> persons = Arrays.asList(
            new Person(1, "Juan", "Perez", 65, Arrays.asList(new Symptom("AB212", "Fiebre", "leve"))),
            new Person(2, "Maria", "Del Valle", 20, Arrays.asList(new Symptom("AB212", "Fiebre", "leve"))),
            new Person(3, "Daniel", "Kratto", 80, Arrays.asList(new Symptom("AB212", "Fiebre", "leve"),  new Symptom("VP216","Vomito","grave")))
    );

    public List<Person> getPersons(){
        return persons;
    }
}
