package com.example.ejercicio_deportistas.service;

import com.example.ejercicio_deportistas.dto.LevelDTO;
import com.example.ejercicio_deportistas.dto.SportDTO;
import com.example.ejercicio_deportistas.dto.SportPersonDTO;

import java.util.List;

public interface ISportService {
    List<SportDTO> getAll();
    LevelDTO getSportLevel(String name);
}
