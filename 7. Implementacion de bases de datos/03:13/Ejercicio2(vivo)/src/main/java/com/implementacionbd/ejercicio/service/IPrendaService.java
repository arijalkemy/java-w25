package com.implementacionbd.ejercicio.service;

import java.util.List;

import com.implementacionbd.ejercicio.dto.MessageDTO;
import com.implementacionbd.ejercicio.dto.PrendaDTO;

public interface IPrendaService {
    public MessageDTO postPrenda(PrendaDTO prendaDTO);

    public List<PrendaDTO> findAllPrendas();

    public PrendaDTO findPrendaById(String id);

    public MessageDTO deletePrenda(String id);

    public PrendaDTO putPrenda(String id, PrendaDTO prendaDTO);

    public List<PrendaDTO> findPrendaBySize(String size);

    public List<PrendaDTO> findPrendaTipo(String tipo);

}
