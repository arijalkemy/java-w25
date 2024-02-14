package main.repository;

import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import main.entity.Personaje;

@Repository
public class PersonajeRepository {
        private List<Personaje> listaPersonajesStarWars;

        public PersonajeRepository() {
                this.listaPersonajesStarWars = loadPersonajes();
        }

        private List<Personaje> loadPersonajes() {
                File file = null;
                List<Personaje> personajes = new ArrayList<>();
                try {
                        file = ResourceUtils.getFile("src/main/java/main/repository/starwars.json");
                        ObjectMapper mapperJSON = new ObjectMapper();
                        TypeReference<List<Personaje>> typeRef = new TypeReference<>() {
                        };
                        personajes = mapperJSON.readValue(file, typeRef);
                } catch (IOException e) {
                        e.printStackTrace();
                }
                return personajes;

        }

        public List<Personaje> getListaPersonajesStarWars() {
                return listaPersonajesStarWars;
        }

}
