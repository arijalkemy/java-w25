package com.example.ejercicio_lasPerlas.service;

import com.example.ejercicio_lasPerlas.dto.NoIdJoyaDTO;
import com.example.ejercicio_lasPerlas.dto.response.JoyaDTO;
import com.example.ejercicio_lasPerlas.dto.response.SaveDTO;

import java.util.List;

public interface IJoyaService {
    SaveDTO save(NoIdJoyaDTO noIdJoyaDTO);

    List<JoyaDTO> list();

    void remove(Long id);

    NoIdJoyaDTO update(Long id, NoIdJoyaDTO noIdJoyaDTO);
}
