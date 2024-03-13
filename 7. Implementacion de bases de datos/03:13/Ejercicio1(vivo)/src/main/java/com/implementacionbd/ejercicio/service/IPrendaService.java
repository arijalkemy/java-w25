package com.implementacionbd.ejercicio.service;

import java.util.List;

import com.implementacionbd.ejercicio.dto.MessageDTO;
import com.implementacionbd.ejercicio.dto.PrendaDTO;

public interface IPrendaService {
    public MessageDTO postPrenda(PrendaDTO prendaDTO);

    public List<PrendaDTO> findAllPrendas();

    public PrendaDTO findPrendaById(Long id);

    public MessageDTO deletePrenda(Long id);

    public PrendaDTO putPrenda(Long id, PrendaDTO prendaDTO);
}
