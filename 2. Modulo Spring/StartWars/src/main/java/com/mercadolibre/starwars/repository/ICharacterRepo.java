package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.base.Characters;

import java.util.List;

public interface ICharacterRepo {
    List<Characters> getCharacterByName(String value);
    List<Characters> gerAll();

}
