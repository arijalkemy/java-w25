package com.springlh.starwars_sala2.service;

import com.springlh.starwars_sala2.repository.CharacterRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springlh.starwars_sala2.dto.CharacterDTO;
import com.springlh.starwars_sala2.dto.mapper.CharacterMapper;

import java.util.List;

@Service
public class CharacterService {

    @Autowired
    CharacterRepositoryImp characterRepository;

    public List<CharacterDTO> findByName(String nombre) {

        return CharacterMapper.getInstances(characterRepository.findByName(nombre));
    }
}
