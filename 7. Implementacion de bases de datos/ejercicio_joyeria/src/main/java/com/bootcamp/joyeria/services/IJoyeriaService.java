package com.bootcamp.joyeria.services;

import com.bootcamp.joyeria.dto.GenericResponseDTO;
import com.bootcamp.joyeria.dto.JoyaDTO;

import java.util.List;

public interface IJoyeriaService {
    GenericResponseDTO<Integer> save(JoyaDTO joyaDTO);
    GenericResponseDTO<String> delete(Integer id);
    GenericResponseDTO<String> update(Integer id, JoyaDTO joyaDTO);
    List<JoyaDTO> findAll();
}
