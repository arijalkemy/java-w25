package com.showroom.exercise.service;

import com.showroom.exercise.dto.PrendaDTO;
import com.showroom.exercise.dto.ResponseDTO;

import java.util.List;

public interface IPrendaService {
    PrendaDTO savePrenda(PrendaDTO prendaDTO);
    List<PrendaDTO> getPrendas();
    PrendaDTO getPrendaById(Long id);
    PrendaDTO updatePrenda(Long id, PrendaDTO prendaDTO);
    ResponseDTO deletePrenda(Long id);
    List<PrendaDTO> getPrendasByTalla(String talla);
    List<PrendaDTO> getPrendasContainsNombre(String nombre);
}
