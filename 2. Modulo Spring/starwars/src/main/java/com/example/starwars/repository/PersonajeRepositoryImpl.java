package com.example.starwars.repository;

import com.example.starwars.model.Personaje;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonajeRepositoryImpl implements IPersonajeRepository {

    public List<Personaje> personajes;
    public PersonajeRepositoryImpl() {
        readJsonFile();
    }

    public void readJsonFile(){
        try {
            ObjectMapper mapper = new ObjectMapper();
            personajes = List.of(mapper.readValue(ResourceUtils.getFile("classpath:starwars.json"), Personaje[].class));
        }catch (IOException iioException){
            throw new RuntimeException(iioException.getMessage());
        }
    }

//   public PersonajeRepositoryImpl(String nombre){
//       String filePath = "src/main/resources/starwars.json";
//
//       try (Reader reader = new FileReader(filePath)) {
//
//           Gson gson = new Gson();
//           JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
//
//           System.out.println("Contenido del archivo JSON:\n" + jsonObject);
//
//       } catch (Exception e) {
//           e.printStackTrace();
//       }
//    }

    @Override
    public List<Personaje> findByName(String word) {
       return personajes.stream()
                .filter(personaje -> Arrays.asList(personaje.getName().split(" ")).contains(word)
                || personaje.getName().equals(word)).collect(Collectors.toList());
    }
}
