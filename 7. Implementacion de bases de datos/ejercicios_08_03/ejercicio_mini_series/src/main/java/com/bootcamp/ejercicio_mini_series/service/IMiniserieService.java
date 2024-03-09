package com.bootcamp.ejercicio_mini_series.service;

import com.bootcamp.ejercicio_mini_series.dto.request.MiniserieRequestDTO;
import com.bootcamp.ejercicio_mini_series.dto.response.MiniserieResponseDTO;

import java.util.List;

public interface IMiniserieService {
    List<MiniserieResponseDTO> findAll();
    MiniserieResponseDTO findMiniserieById(Long id);
    void save(MiniserieRequestDTO miniserieRequestDTO);
    MiniserieResponseDTO getByName(String name);
    void deleteById(Long id);
}
