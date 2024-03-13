package com.example.practicaES.service;

import com.example.practicaES.dto.MessageDto;
import com.example.practicaES.dto.ObraDto;

import java.util.List;

public interface IObraService {
    MessageDto addObra(ObraDto obraDto);
    List<ObraDto> findAll();
    List<ObraDto> findByAutor(String autor);
    List<ObraDto> findByNombre(String nombre);
    List<ObraDto> getTop5Pages();
    List<ObraDto> findByYearBefore(Integer year);
    List<ObraDto> findByEditorial(String editorial);
}
