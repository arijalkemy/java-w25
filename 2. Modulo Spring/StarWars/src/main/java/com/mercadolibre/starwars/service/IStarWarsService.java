package com.mercadolibre.starwars.service;


import com.mercadolibre.starwars.dto.PersonajeDTO;

import java.util.List;

public interface IStarWarsService {
    List<PersonajeDTO> searchCharacter(String query);
}
