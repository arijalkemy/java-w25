package com.mercadolibre.starwars.util;

import com.mercadolibre.starwars.dto.CharacterDTO;

public class TestGeneratorUtil {
    public static CharacterDTO getLuke(){
        return new CharacterDTO(
                "Luke Skywalker",
                172,
                77,
                "blond",
                "fair",
                "blue",
                "19BBY",
                "male",
                "Tatooine",
                "Human"
        );

    }

}
