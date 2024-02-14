package bootcamp.deportistas.controller;

import bootcamp.deportistas.dto.SportLevelDTO;
import bootcamp.deportistas.dto.SportsDTO;
import bootcamp.deportistas.dto.SportPersonDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import bootcamp.deportistas.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class SportController {
    private List<Sport> sportsList = new ArrayList<>(List.of(
            new Sport("Football",3),
            new Sport("RockClimbing",5),
            new Sport("American Football",4),
            new Sport("Basketball",3),
            new Sport("Tenis",2),
            new Sport("Golf",1)
    ));
    private List<Person> personList = new ArrayList<>(List.of(
            new Person("Camila","Narvaez",17),
            new Person("Daniel","Echeverry",27),
            new Person("Tomas","Prado",22),
            new Person("Juliana","Moreno",23),
            new Person("Alejandro","Torres",2),
            new Person("Marlen","Arias",1)
    ));

    private List<SportPersonDTO> sportPersonList = new ArrayList<>(Arrays.asList(
            new SportPersonDTO(personList.get(0).getName(),personList.get(0).getLastName(),sportsList.get(3).getName()),
            new SportPersonDTO(personList.get(2).getName(),personList.get(0).getLastName(),sportsList.get(0).getName()),
            new SportPersonDTO(personList.get(5).getName(),personList.get(0).getLastName(),sportsList.get(2).getName())
    ));

    @GetMapping("/findSports")
    public ResponseEntity<List<Sport>> findSports(){
        SportsDTO sportListDTO = new SportsDTO(sportsList);
        return new ResponseEntity<>(sportListDTO.getSportsList(), HttpStatus.OK);
    }
    @GetMapping("/findSport/{name}")
    public ResponseEntity<SportLevelDTO> findSports(@PathVariable String name){
        Optional<Sport> sportName = sportsList.stream().filter(s -> s.getName().toLowerCase().equals(name.toLowerCase())).findFirst();
        if(sportName.isPresent()){
            SportLevelDTO sportLevelDTO = new SportLevelDTO(sportName.get().getLevel());
            return new ResponseEntity<>( sportLevelDTO, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<SportPersonDTO>> findSportsPersons(){

        return new ResponseEntity<>(sportPersonList, HttpStatus.OK);
    }
}
