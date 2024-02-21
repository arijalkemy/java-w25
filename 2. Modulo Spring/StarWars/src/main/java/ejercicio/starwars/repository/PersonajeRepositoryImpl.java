package ejercicio.starwars.repository;
import java.io.FileReader;

import ejercicio.starwars.dto.PersonajeDTO;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonajeRepositoryImpl implements PersonajeRepository{

    @Override
    public List<PersonajeDTO> mostrarPersonajes(String personaje) {
        return null;
    }

    public void readJsonFile(String path){
        JSONParser parser = new JSONParser();

        GsonJsonParser



    }

}
