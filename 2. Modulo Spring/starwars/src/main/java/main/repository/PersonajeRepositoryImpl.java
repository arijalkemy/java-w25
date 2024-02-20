package main.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import main.model.Personaje;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.List;

@Repository
public class PersonajeRepositoryImpl implements IPersonajeRepository{

    public List<Personaje> getAllCharacters(){
        try {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Personaje>> typeReference = new TypeReference<>(){};
            List<Personaje> characters = mapper.readValue(new File("src/main/resources/starwars.json"), typeReference);
            return characters;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
