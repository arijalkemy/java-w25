package PersonajeStarWars.repositories;

import PersonajeStarWars.dto.DtoPersonaje;
import PersonajeStarWars.entities.Personaje;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonajeRepo{
    public List<Personaje> getPersonajesRepo() {
        List<Personaje> personajesList = loadDataBase();
        return personajesList;
    }

    private List<Personaje> loadDataBase() {
        ObjectMapper mapper = new ObjectMapper();
        File jsonFile = null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:starwars.json");
            return mapper.readValue(jsonFile, new TypeReference<List<Personaje>>(){});
        } catch (IOException e) {
            System.out.println("No existe el archivo "+ e.getMessage());
        }
        return new ArrayList<>();
    }
}
