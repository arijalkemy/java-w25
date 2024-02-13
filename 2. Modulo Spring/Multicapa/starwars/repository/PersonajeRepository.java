package repository;

import com.example.controllerW25.starwars.entity.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonajeRepository {

    private List<Personaje> personajes;

    public PersonajeRepository(){
        this.personajes = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            this.personajes = objectMapper.readValue(new File("/Users/sjaramillooc/IdeaProjects/controllerW25/src/main/resources/starwars.json"), new TypeReference<List<Personaje>>() {});
        } catch (IOException e) {
            System.out.println("Error en la lectura del archivo json");
            throw new RuntimeException(e);
        }
    }

    public List<Personaje> getPersonajes() {
        return personajes;
    }
}
