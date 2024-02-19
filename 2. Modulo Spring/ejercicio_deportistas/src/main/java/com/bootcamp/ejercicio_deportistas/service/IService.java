package com.bootcamp.ejercicio_deportistas.service;


import com.bootcamp.ejercicio_deportistas.dto.DeporteDto;
import com.bootcamp.ejercicio_deportistas.dto.DeportistaDto;
import com.bootcamp.ejercicio_deportistas.dto.NivelDeporteDto;

import java.util.List;

public interface IService {
    public List<DeporteDto> getAllSports();
    NivelDeporteDto getSportByName(String name);

    List<DeportistaDto> getSportsman();

}
