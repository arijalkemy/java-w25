package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;

import java.util.List;

public interface StarWarsService {

//    puedo no poner public porque por default los métodos son públicos en una interfaz
    List<CharacterDTO> findCharacters(String name);
}
