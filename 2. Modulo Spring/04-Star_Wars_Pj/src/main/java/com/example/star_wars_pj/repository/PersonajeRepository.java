package com.example.star_wars_pj.repository;

import com.example.star_wars_pj.entity.Personaje;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.apache.tomcat.util.json.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Data
public class PersonajeRepository {

    private List<Personaje> personajesSW;

    public PersonajeRepository() {

        this.personajesSW = List.of(loadPersonajes());
    }



    private Personaje[] loadPersonajes(){
        ObjectMapper mapperJSON  = new ObjectMapper();
        String ruta ="src/main/resources/static/starwars_data.json";

        try {
            return mapperJSON.readValue(new File(ruta), Personaje[].class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }


    }



}
