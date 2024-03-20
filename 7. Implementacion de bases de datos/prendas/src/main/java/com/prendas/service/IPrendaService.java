package com.prendas.service;

import com.prendas.dto.PrendaDto;
import com.prendas.dto.ResponseDto;

import java.util.List;

public interface IPrendaService {
     ResponseDto save(PrendaDto prendaDto);
     List<PrendaDto> getCloths();
     List<PrendaDto> getClothBySize(String size);
     PrendaDto getClotheByCode(Long code);
     ResponseDto updateClothe(Long code, PrendaDto prendaDto);
     ResponseDto deleteClothe(Long code);
     List<PrendaDto> getClotheByName(String name);
}
