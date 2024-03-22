package com.example.ejercicio_deportistas.service;

import com.example.ejercicio_deportistas.dto.LevelDTO;
import com.example.ejercicio_deportistas.dto.SportDTO;
import com.example.ejercicio_deportistas.dto.SportPersonDTO;
import com.example.ejercicio_deportistas.entity.Sport;
import com.example.ejercicio_deportistas.exception.NotFoundException;
import com.example.ejercicio_deportistas.repository.ISportRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SportServiceImpl implements ISportService{
    ISportRepository sportRepository;
    ModelMapper mapper;
    public SportServiceImpl(ISportRepository sportRepository) {

        this.sportRepository = sportRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public List<SportDTO> getAll() {
        List<SportDTO> sportDTOList = sportRepository.findAll().stream().map(sport -> this.mapper.map(sport, SportDTO.class)).toList();
        if (sportDTOList.isEmpty()) throw new NotFoundException("No se encontraron deportes");
        return sportDTOList;
    }

    @Override
    public LevelDTO getSportLevel(String name) {
        Optional<Sport> sport = sportRepository.findByName(name);
        if (sport.isEmpty()) throw new NotFoundException("No se encuentra el deporte");
        return mapper.map(sport.get(), LevelDTO.class);
    }
}
