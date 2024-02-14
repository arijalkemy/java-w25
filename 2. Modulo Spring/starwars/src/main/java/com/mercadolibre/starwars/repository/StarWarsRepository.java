package com.mercadolibre.starwars.repository;
import com.mercadolibre.starwars.model.Character;

import java.util.List;

public interface StarWarsRepository {

   List<Character> loadCharacters();
}
