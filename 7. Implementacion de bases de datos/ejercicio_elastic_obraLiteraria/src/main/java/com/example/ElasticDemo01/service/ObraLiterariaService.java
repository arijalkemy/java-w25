package com.example.ElasticDemo01.service;

import com.example.ElasticDemo01.dto.ObraLiterariaDTO;
import com.example.ElasticDemo01.dto.ObraLiterariaFiltrosDTO;
import com.example.ElasticDemo01.dto.ResponseDto;

import java.util.List;

public interface ObraLiterariaService {

    ResponseDto saveBook(ObraLiterariaDTO bookDTO);

    List<ObraLiterariaDTO> getAll();
    List<ObraLiterariaDTO> getObraByAutor(ObraLiterariaFiltrosDTO filtros);
    List<ObraLiterariaDTO> getObraByPalabraClave(ObraLiterariaFiltrosDTO filtros);
    List<ObraLiterariaDTO> getTop5ByCantPag();
    List<ObraLiterariaDTO> getBeforeDate(ObraLiterariaFiltrosDTO filtros);
    List<ObraLiterariaDTO> getByEditorial(ObraLiterariaFiltrosDTO filtros);
}
