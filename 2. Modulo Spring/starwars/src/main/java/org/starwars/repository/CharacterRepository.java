package org.starwars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.tools.javac.Main;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import org.starwars.entity.Personaje;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CharacterRepository {
    private List<Personaje> personajeList;

    public CharacterRepository() {

    }


    public List<Personaje> test() {
        ObjectMapper map = new ObjectMapper();
        List<Personaje> personajes;
        File jsonFile = null;
        try {
            jsonFile = ResourceUtils.getFile("classpath:test.json");
            //personajes = map.readValue(jsonFile, new TypeReference<List<Personaje>>() {});
        } catch (IOException e) {
            System.out.println("No existe el archivo. " + e.getMessage());
        }

        return personajes;
    }

}
