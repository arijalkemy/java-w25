package bootcamp.dtoresponseentityvivo.service;

import bootcamp.dtoresponseentityvivo.dto.SportsmanDto;
import bootcamp.dtoresponseentityvivo.model.Person;
import bootcamp.dtoresponseentityvivo.model.Sport;
import bootcamp.dtoresponseentityvivo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SportsmanServiceImp implements ISportsmanService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<SportsmanDto> findSportsmen() {
        List<SportsmanDto> sportsmanDtos = new ArrayList<>();

        for (Person person : personRepository.getPeople()) {
            if (person.getSports().isEmpty()) continue;
            SportsmanDto sportsmanDto = new SportsmanDto(person.getFirstName() + " " + person.getLastName(), person.getSports().stream().map(Sport::getName).collect(Collectors.toList()));
            sportsmanDtos.add(sportsmanDto);
        }

        return sportsmanDtos;
    }

}
