package com.joyeria.Joyeria.service;


import com.joyeria.Joyeria.dto.JoyaRequestDTO;
import com.joyeria.Joyeria.dto.JoyaResponseDTO;
import com.joyeria.Joyeria.dto.MessageDto;
import com.joyeria.Joyeria.model.Joya;

import java.util.List;

public interface IJoyaService {
    public String createJoya(JoyaRequestDTO joyaDto);
    public List<Joya> getAllJoyas();
    public JoyaResponseDTO findJoyaById(Long id);
    public String deleteJoya(Long id);
    public JoyaResponseDTO updateJoya(Long id, JoyaRequestDTO joyaDto);
}
