package star_wars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import star_wars.entity.Personaje;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Repository
public class PersonajesRepositoryImpl implements  PersonajesRepository{

        private static List<Personaje> personajes;

        public PersonajesRepositoryImpl(){
            readPersonajes("src/main/resources/databases/starwars.json");
        }

        @Override
        public void readPersonajes(String filePath) {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Personaje> personajes = null;
            try {
                personajes = objectMapper.readValue(new File(filePath), new TypeReference<List<Personaje>>(){});
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.personajes = personajes;
            personajesFix();
        }

        @Override
        public List<Personaje> getPersonajes(){
            return personajes;
        }

        @Override
        public void personajesFix(){
            personajes.forEach(personaje -> {
                personaje.setName(personaje.getName().replace("NA", ""));
                personaje.setGender(personaje.getGender().replace("NA", ""));
                personaje.setBirthYear(personaje.getBirthYear().replace("NA", ""));
                personaje.setHomeworld(personaje.getHomeworld().replace("NA", ""));
                personaje.setSpecies(personaje.getSpecies().replace("NA", ""));
                personaje.setHairColor(personaje.getHairColor().replace("NA", ""));
                personaje.setEyeColor(personaje.getEyeColor().replace("NA", ""));
                personaje.setSkinColor(personaje.getSkinColor().replace("NA", ""));
            });
        }
}