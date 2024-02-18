package repository;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import entity.Personaje;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.fasterxml.jackson.core.type.TypeReference;

@Repository
public class StarWarsRepository {

    List<Personaje> personajeList = new ArrayList<>();

    public StarWarsRepository () {

        ObjectMapper mapper = new ObjectMapper();
        try {
            personajeList = mapper.readValue(
                    new File("/Users/nabello/Documents/Java/StarWars/src/main/java/json/personajes.json"),
                    new TypeReference<List<Personaje>>() {
                    });
        }
        catch(IOException err) {
            System.out.println(err.getMessage());
        }
    }

    public List<Personaje> getPersonajes(){
        return personajeList;
    }
}
