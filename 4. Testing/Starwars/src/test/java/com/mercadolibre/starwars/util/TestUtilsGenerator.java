package com.mercadolibre.starwars.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.fasterxml.jackson.databind.SerializationFeature;

public class TestUtilsGenerator {

    private static String SCOPE;
    private static ObjectWriter mapper;

    public static CharacterDTO getLukeSkywalker() {
        return CharacterDTO.builder()
                .name("Luke Skywalker")
                .height(172)
                .mass(77)
                .hair_color("blond")
                .skin_color("fair")
                .eye_color("blue")
                .birth_year("19BBY")
                .gender("male")
                .homeworld("Tatooine")
                .species("Human")
                .build();
    }

    public static String getJsonPayload(Object dto) throws JsonProcessingException {
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        return writer.writeValueAsString(dto);
    }

}
