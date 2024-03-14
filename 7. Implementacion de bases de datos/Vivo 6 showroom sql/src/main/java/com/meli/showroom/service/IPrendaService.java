package com.meli.showroom.service;

import com.meli.showroom.dto.PrendaDTO;

import java.util.List;

public interface IPrendaService {

    void savePrenda(PrendaDTO prendaDTO);
    void saveAll(List<PrendaDTO> prendas);
    List<PrendaDTO> getPrendas();
    PrendaDTO getPrenda(Long id);
    void updatePrenda(Long id, PrendaDTO prendaDTO);
    void deletePrenda(Long id);
    List<PrendaDTO> getPrendasByTalla(String talla);
    List<PrendaDTO> getPrendasByNombre(String nombre);
}
