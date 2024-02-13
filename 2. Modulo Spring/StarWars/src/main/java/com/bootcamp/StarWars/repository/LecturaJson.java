package com.bootcamp.StarWars.repository;

import com.bootcamp.StarWars.entity.Personaje;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class LecturaJson {
    public static List<Personaje> leerArchivoJson() throws FileNotFoundException {
        // String path = "/Users/rgutierrezpa/Desktop/Bootcamp/Spring/StarWars/src/main/java/com/bootcamp/StarWars/repository/starwars.json";

        ObjectMapper objectMapper = new ObjectMapper();

        SimpleModule simpleModule = new SimpleModule();

        simpleModule.addDeserializer(Integer.class, new IntegerDeserializer());
        objectMapper.registerModule(simpleModule);

        File jsonFile = ResourceUtils.getFile("classpath:starwars.json");

        try {
            return objectMapper.readValue(jsonFile, new TypeReference<List<Personaje>>() {});
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private static class IntegerDeserializer extends JsonDeserializer<Integer> {
        @Override
        public Integer deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            String value = p.getValueAsString();
            try {
                // Intenta parsear el valor como entero
                return Integer.parseInt(value);
            } catch (NumberFormatException e) {
                // Si falla, intenta parsear como decimal y convertirlo a entero
                try {
                    Double doubleValue = Double.parseDouble(value);
                    return doubleValue.intValue();
                } catch (NumberFormatException ex) {
                    // Si no se puede convertir a entero, devuelve 0
                    return 0;
                }
            }
        }
    }
}
