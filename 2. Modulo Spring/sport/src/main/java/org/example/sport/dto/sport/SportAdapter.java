package org.example.sport.dto.sport;

import org.example.sport.dto.person.PersonSportDTO;
import org.example.sport.model.Person;
import org.example.sport.model.Sport;

public class SportAdapter {
    public static SportLevelResponseDTO getSportLevelDTO(Sport sport){
        return new SportLevelResponseDTO(sport.getLevel());
    }
    public static SportDTO getSportDTO(Sport sport){
        return new SportDTO(sport);
    }
    public static PersonSportDTO getPersonSportDTO(Person person,Sport sport){
        return new PersonSportDTO(person.getName(),person.getLastName(),sport.getName());
    }
}
