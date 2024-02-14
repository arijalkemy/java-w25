package bootcamp.dtoresponseentityvivo.repository;

import bootcamp.dtoresponseentityvivo.model.Person;
import bootcamp.dtoresponseentityvivo.model.Sport;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonRepository {

    List<Person> people = Arrays.asList(
            new Person("Fulano", "Fulanez",19, Arrays.asList(new Sport("Hockey","profesional"))),
            new Person("Mengano", "Menganios",25, Arrays.asList(new Sport("Fútbol", "Básico"))),
            new Person("Agnostico", "Corasao",17, Arrays.asList(new Sport("Tenis", "Avanzado"))),
            new Person("Alejandro", "Skyrzuchk",36, Arrays.asList(new Sport("Rugby", "Básico"),new Sport("Fútbol", "Básico"))),
            new Person("Hefesto", "Olimpo",43, Arrays.asList(new Sport("Fútbol", "Básico"))),
            new Person("Rigoberta", "Legrand",55, Arrays.asList(new Sport("Natación", "Intermedio"))),
            new Person("Cucho", "Serna",65, Arrays.asList(new Sport("Voley", "Básico"))),
            new Person("Chancho", "Deca",75, Arrays.asList(new Sport("Fútbol", "Básico"),new Sport("Tenis", "Avanzado"))),
            new Person("Chicho", "Chanchi",85, Arrays.asList(new Sport("Voley", "Básico"),new Sport("Rugby", "Básico"),new Sport("Tenis", "Avanzado"))),
            new Person("Serralima", "Martaserra",64, Arrays.asList(new Sport("Natación", "Intermedio")))
    );

    public List<Person> getPeople() {
        return people;
    }

}
