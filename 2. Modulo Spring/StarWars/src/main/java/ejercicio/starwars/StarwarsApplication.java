package ejercicio.starwars;

import aj.org.objectweb.asm.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import ejercicio.starwars.entity.Personaje;
import ejercicio.starwars.repository.PersonajeRepository;
import ejercicio.starwars.service.PersonajeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class StarwarsApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarwarsApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(PersonajeService pjService) {
        return args -> {
            // read json and write to db
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Personaje>> typeReference = new TypeReference<List<Personaje>>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("src/main/resources/static/starwars.json");
            try {
                List<Personaje> users = mapper.readValue(inputStream,typeReference);
                pjService.save(users);
                System.out.println("Users Saved!");
            } catch (IOException e){
                System.out.println("Unable to save users: " + e.getMessage());
            }
        };
    }
}
