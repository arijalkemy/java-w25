package com.sfritz.deportistas.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sfritz.deportistas.dto.responses.LevelDTO;
import com.sfritz.deportistas.dto.responses.PersonDTO;
import com.sfritz.deportistas.dto.responses.SportDTO;
import com.sfritz.deportistas.dto.responses.SportsPersonsDTO;
import com.sfritz.deportistas.models.Person;
import com.sfritz.deportistas.models.Sport;

@RestController
@RequestMapping("/sports")
public class SportsController {

    @GetMapping("/findSports")
    public ResponseEntity<List<SportDTO>>findSports(){
        List<Sport> sports = generateSports();
        List<SportDTO> sportsDto = new ArrayList<>();
        for(Sport s:sports){
            sportsDto.add(new SportDTO(s.getName(),s.getLevel()));
        }
        return new ResponseEntity<List<SportDTO>>(sportsDto,HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<LevelDTO> findSportByName(@PathVariable String name){
        try {
            return new ResponseEntity<LevelDTO>(new LevelDTO(generateSports().stream().filter(s -> s.getName().equals(name)).findFirst().orElseThrow().getLevel()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new LevelDTO(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<SportsPersonsDTO>> findSportsPersons(){
        List<Person> persons = generatePersons();
        List<PersonDTO> personDtos = new ArrayList<>();
        for(Person p:persons){
            List<SportDTO> sportDTOs = new ArrayList<>();
            PersonDTO pDto = new PersonDTO();
            pDto.setName(p.getName());
            pDto.setLastname(p.getLastname());
            for(Sport s:p.getSports()){
                sportDTOs.add(new SportDTO(s.getName(),s.getLevel()));
            }
            pDto.setSports(sportDTOs);
            personDtos.add(pDto);
        }
        List<SportsPersonsDTO> sportsPersonsDtos = new ArrayList<>();
        for(PersonDTO personDTO: personDtos){
            sportsPersonsDtos.add(new SportsPersonsDTO(personDTO.getName(), personDTO.getLastname(),personDTO.getSports().stream().map(s -> s.getName()).toList()));
        }
        
        return new ResponseEntity<List<SportsPersonsDTO>>(sportsPersonsDtos, HttpStatus.OK);
    }
// ----------------------------
//Generar los modelos Person y Sport.
    private List<Person> generatePersons(){
        List<Sport> sports = generateSports();
        return Arrays.asList(
            new Person("Jhon","Doe",40,sports.stream().filter(s -> s.getName().equals("Tenis")).collect(Collectors.toList())),
            new Person("Ricardo","Smith",25,sports.stream().filter(s -> s.getName().equals("Football")).collect(Collectors.toList())),
            new Person("Pepe","Pipe",22,sports.stream().filter(s -> s.getName().equals("Esgrima")).collect(Collectors.toList())),
            new Person("Jose","Gonzalez",30,sports.stream().filter(s -> s.getName().equals("Basquetball") || s.getName().equals("Tenis")).collect(Collectors.toList()))
        );
    }

    private List<Sport> generateSports(){
        return Arrays.asList(
            new Sport("Football", 1),
            new Sport("Basquetball", 2),
            new Sport("Esgrima", 4),
            new Sport("Tenis", 3)
        );
    }
}
