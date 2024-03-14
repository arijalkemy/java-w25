package com.bootcamp.ejercicio_relaciones.service;

import com.bootcamp.ejercicio_relaciones.dto.AdressDTO;
import com.bootcamp.ejercicio_relaciones.dto.ResponseDTO;
import com.bootcamp.ejercicio_relaciones.model.Adress;

import java.util.List;

public interface IAdressService {
    ResponseDTO save(AdressDTO adress);
    ResponseDTO delete(Long id);
    List<AdressDTO> getAll();
}
