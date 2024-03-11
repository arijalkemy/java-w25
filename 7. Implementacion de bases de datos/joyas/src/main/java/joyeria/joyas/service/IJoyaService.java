package joyeria.joyas.service;


import joyeria.joyas.DTO.Response.GenericResponseDto;
import joyeria.joyas.DTO.Response.JoyaDTO;
import joyeria.joyas.entity.Joya;

import java.util.List;

public interface IJoyaService {
    GenericResponseDto create(JoyaDTO joya);
    List<Joya> findAll();
    GenericResponseDto delete(Long id);
    GenericResponseDto update(Joya joya);
}
