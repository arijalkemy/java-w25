package com.example.ElasticDemo01.service;

import com.example.ElasticDemo01.dto.ObraDto;
import com.example.ElasticDemo01.dto.ResponseDto;

import java.util.List;

public interface IObraService {
    ResponseDto saveObra(ObraDto emp);
    ResponseDto saveObras(List<ObraDto> obras);
    List<ObraDto> getAll();
    List<ObraDto> getByTitulo(String titulo);
    List<ObraDto> getByAutor(String autor);
    List<ObraDto> getOrderByPageDesc();
    List<ObraDto> getBeforeYear(String anio);
    List<ObraDto> getByEditorial(String editorial);
}
