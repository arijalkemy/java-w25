package com.example.ejercicio_deportistas.service;

import com.example.ejercicio_deportistas.dto.SportPersonDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPersonService {
    List<SportPersonDTO> findSportPerson();
}
