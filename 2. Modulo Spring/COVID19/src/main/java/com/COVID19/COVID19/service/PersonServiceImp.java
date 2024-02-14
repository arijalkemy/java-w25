package com.COVID19.COVID19.service;

import com.COVID19.COVID19.dto.RiskPersonDto;
import com.COVID19.COVID19.model.Person;
import com.COVID19.COVID19.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;

public class PersonServiceImp implements IPersonsService{

    @Override
    public List<RiskPersonDto> getRiskPersons() {
        PersonRepository personRepository = new PersonRepository();

        List<Person> persons = personRepository.getPersons();

        List<RiskPersonDto> riskPersons = new ArrayList<>();
        for (Person person : persons){
            if(person.getAge()>=60){
                riskPersons.add(new RiskPersonDto(person.getFirstName(), person.getLastName(),person.getSyntoms().stream().map(sym -> sym.getName()).toList()));
            }
        }
        return riskPersons;
    }
}
