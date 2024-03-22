package com.mercadolibre.app_deportistas_nq.service.impl;

import com.mercadolibre.app_deportistas_nq.dtos.PersonDTO;
import com.mercadolibre.app_deportistas_nq.dtos.PersonSportsDTO;
import com.mercadolibre.app_deportistas_nq.entity.Person;
import com.mercadolibre.app_deportistas_nq.entity.Sport;
import com.mercadolibre.app_deportistas_nq.repository.PersonRepository;
import com.mercadolibre.app_deportistas_nq.repository.SportRepository;
import com.mercadolibre.app_deportistas_nq.service.IPersonService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements IPersonService {

    private final PersonRepository personRepository;
    private final SportRepository sportRepository;
    private final ModelMapper mapper;

    public PersonServiceImpl(PersonRepository personRepository, SportRepository sportRepository, ModelMapper mapper) {
        this.personRepository = personRepository;
        this.sportRepository = sportRepository;
        this.mapper = mapper;
    }

    @Override
    public List<PersonDTO> findPersons() {
        return personRepository.findAll().stream().map(c -> mapper.map(c, PersonDTO.class)).toList();
    }

    @Override
    public List<PersonSportsDTO> findPersonSports() {
        List<PersonSportsDTO> sportsmanDtos = new ArrayList<>();

        for (Person person : personRepository.findAll()) {
            List<Sport> sports = sportRepository.findSportsByPersonId(person.getId());
            if (sports.isEmpty()) continue;

            List<String> sportNames = new ArrayList<>();
            for (Sport sport : sports) {
                sportNames.add(sport.getName());
            }

            PersonSportsDTO sportsmanDto =
                    new PersonSportsDTO(
                            person.getName() + " " + person.getSurname(),
                            sportNames
                    );
            sportsmanDtos.add(sportsmanDto);
        }
        return sportsmanDtos;
    }
}
