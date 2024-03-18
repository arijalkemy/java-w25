package ejercicio.starwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ejercicio.starwars.entity.Personaje;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonajeRepositoryImpl implements PersonajeRepository{

    private List<Personaje> personajes;

    public PersonajeRepositoryImpl() {
        this.personajes = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            this.personajes = objectMapper.readValue(new File(
                    "/Users/jgrisalesqui/Documents/Ejercicios Springboot/Ejercicio4-Starwars/src/main/resources/static/starwars.json"),
                    new TypeReference<List<Personaje>>() {});
        } catch (IOException e) {
            System.out.println("Error en la lectura del archivo json");
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Personaje> mostrarPersonajes() {
        return personajes;
    }

}
