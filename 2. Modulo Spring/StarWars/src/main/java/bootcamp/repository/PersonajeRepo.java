package bootcamp.repository;

import bootcamp.model.Personaje;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class PersonajeRepo {

    public List<Personaje> cargarJsonPersonajes(){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ;
            return objectMapper.readValue(
                    new ClassPathResource("starwars.json").getInputStream(),
                    new TypeReference<List<Personaje>>() {
                    });
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
