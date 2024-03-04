package org.example.sport.controller;

import org.example.sport.dto.person.PersonSportDTO;
import org.example.sport.dto.sport.SportAdapter;
import org.example.sport.dto.sport.SportDTO;
import org.example.sport.dto.sport.SportLevelResponseDTO;
import org.example.sport.model.Person;
import org.example.sport.model.Sport;
import org.example.sport.repository.common.IRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sport")
public class SportController {

    private IRepository<Sport,Integer> sportRepository;
    private IRepository<Person,Integer> personRepository;

    public SportController(IRepository sportRepository,IRepository personRepository){
        this.sportRepository = sportRepository;
        this.personRepository = personRepository;
    }
    @GetMapping("/findSports")
    public ResponseEntity<ArrayList<SportDTO>> getAll(){
        return ResponseEntity.ok(this.sportRepository.getAll().stream()
                .map(element -> SportAdapter.getSportDTO(element)).collect(Collectors
                        .toCollection(ArrayList::new)));
    }
    @GetMapping("/findSport/{name}")
    public ResponseEntity<SportLevelResponseDTO> getByNam(@PathVariable String name){
        return ResponseEntity.ok(SportAdapter.getSportLevelDTO(this.sportRepository
                .getAll().stream().filter(sport -> sport.getName().toLowerCase()
                        .equals(name.toLowerCase())).findFirst().get()));
    }
    @GetMapping("/findSportsPersons")
    public ResponseEntity<ArrayList<PersonSportDTO>> getAllPersonWithSport(){
        return ResponseEntity.ok(this.personRepository.getAll().stream().map(person -> SportAdapter
                .getPersonSportDTO(person,this.sportRepository.getAll().get(new Random()
                        .nextInt(this.sportRepository.getAll().size()-1))))
                .collect(Collectors.toCollection(ArrayList::new)));
    }
}
