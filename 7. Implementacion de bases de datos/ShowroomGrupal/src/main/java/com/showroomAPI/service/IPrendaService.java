package com.showroomAPI.service;

import com.showroomAPI.dto.request.PrendaDto;
import com.showroomAPI.dto.response.MessageDto;

import java.util.List;

public interface IPrendaService {

    MessageDto createPrenda(PrendaDto prendaDto);
    List<PrendaDto> getPrendas();
    PrendaDto getPrendaByCode(Long id);
    MessageDto updatePrendaByCode(Long code, PrendaDto prendaDto);

}
