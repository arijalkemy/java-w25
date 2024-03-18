package com.practica.elastic.service;

import com.practica.elastic.dto.MessageDTO;
import com.practica.elastic.dto.ObrasDTO;

import java.time.LocalDate;
import java.util.List;

public interface IObrasService {

    MessageDTO crearObra(ObrasDTO obrasDTO);
    List<ObrasDTO> getAll();
    List<ObrasDTO> findByDate(LocalDate date);
    List<ObrasDTO> findByPage();
    List<ObrasDTO> findByEditorial(String editorial);
    List<ObrasDTO> findByAutor(String autor);
    List<ObrasDTO> findByName(String name);
}
