package com.example.concesionario.services;

import com.example.concesionario.dto.AutomovilDto;
import com.example.concesionario.entities.Automovil;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

public interface IConcesionarioService {
    AutomovilDto addAutomovil(Automovil automovil);

    List<AutomovilDto> getAllAutomoviles();

    List<AutomovilDto> getAllAutomovilesByDate(Date dateMin, Date dateMax);

    List<AutomovilDto> getAllAutomovilesByPrice(double priceMin, double priceMax);

    AutomovilDto getAutomovil(int id);
}
