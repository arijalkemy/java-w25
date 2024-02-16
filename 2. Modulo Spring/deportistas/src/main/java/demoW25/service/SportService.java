package demoW25.service;

import demoW25.dto.PersonDTO;
import demoW25.dto.SportDTO;
import demoW25.model.Person;
import demoW25.model.Sports;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SportService {

    private final List<Sports> list = new ArrayList<>();
    private final List<Person> personList = new ArrayList<>();
    public List<Sports> getSport(){
        initList();
        return list;
    }

    public SportDTO getOneSport(String name){
        initList();
        Optional<Sports> sportsOptional = list.stream().
                filter(s -> s.getNombre().equals(name)).
                findFirst();

        SportDTO sportDTO;

        if (sportsOptional.isPresent()){
            sportDTO = new SportDTO(sportsOptional.get(), null);
        }else{
            sportDTO = new SportDTO(null, "Deporte no encontrado");
        }

        return sportDTO;
    }

    public List<PersonDTO> getPerson(){

        initList();
        List<PersonDTO> personDTOList = new ArrayList<>();
        personList.forEach(person -> personDTOList.add(new PersonDTO(person.getNombre(),
                person.getApellido(),
                person.getDeporte().getNombre())));

        return personDTOList;
    }

    private void initList(){

        Sports sport1 = new Sports("Futbol", 1);
        Sports sport2 = new Sports("Baloncesto", 2);
        Sports sport3 = new Sports("Beisbol", 3);
        Sports sport4 = new Sports("Tenis", 4);


        list.add(sport1);
        list.add(sport2);
        list.add(sport3);
        list.add(sport4);

        Person person1 = new Person("Pepito", "Perez", 23, sport1);
        Person person2 = new Person("Raul", "Sanchez", 45, sport2);
        Person person3 = new Person("Luisa", "Gomez", 32, sport3);

        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
    }
}
