package com.bootcamp.elasticSearch.service;

import com.bootcamp.elasticSearch.dto.ObraLiterariaDto;
import com.bootcamp.elasticSearch.dto.ResponseDto;

import java.util.List;

public interface IObraLiterariaService {

    ResponseDto saveObra(ObraLiterariaDto obraLiterariaDto);

    List<ObraLiterariaDto> getObrasByAutor(String autor);
    List<ObraLiterariaDto> getObrasByTitulo(String keyWord);
    List<ObraLiterariaDto> getObrasTop5QuantityPages();

    List<ObraLiterariaDto>  getObrasBefore(int anio);

    List<ObraLiterariaDto> getObrasByEditorial(String editorial);

}
