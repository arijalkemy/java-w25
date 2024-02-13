package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.base.Characters;
import com.mercadolibre.starwars.dto.CharctersDto;
import com.mercadolibre.starwars.repository.CharacterRepoImp;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class CharacterService {

    private CharacterRepoImp characterRepo;

    public CharacterService(CharacterRepoImp characterRepo){
        this.characterRepo = characterRepo;
    }

    public List<CharctersDto> findByName(String name){
        List<Characters> charactersList = characterRepo.getCharacterByName(name);
        List<CharctersDto> charctersDtosList = new ArrayList<>();
        for( Characters c: charactersList){
            charctersDtosList.add(new CharctersDto(c));
        }
        return charctersDtosList;
    }

    public List<CharctersDto> findAll(){
        List<Characters> charactersList = characterRepo.gerAll();
        List<CharctersDto> charctersDtosList = new ArrayList<>();
        for( Characters c: charactersList){
            charctersDtosList.add(new CharctersDto(c));
        }
        return charctersDtosList;
    }
}
