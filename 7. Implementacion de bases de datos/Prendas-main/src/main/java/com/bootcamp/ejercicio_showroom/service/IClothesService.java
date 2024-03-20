package com.bootcamp.ejercicio_showroom.service;

import com.bootcamp.ejercicio_showroom.dto.request.PrendaRequDto;
import com.bootcamp.ejercicio_showroom.dto.response.PrendaRespDto;
import com.bootcamp.ejercicio_showroom.dto.response.ResponseDTO;

import java.util.List;

public interface IClothesService {
    List<PrendaRespDto> getAllClothes();
    PrendaRespDto getClothesByCode(Long code);
    List<PrendaRespDto> getClothesBySize(String size);
    PrendaRespDto addPrenda(PrendaRequDto requDto);
    PrendaRespDto updatePrenda(Long id, PrendaRequDto requDto);
    List<PrendaRespDto> getClothesByWord(String word);

    ResponseDTO deleteClothesById(Long id);
}
