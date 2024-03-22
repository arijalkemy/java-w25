package com.obrasliterarias.elasticsearch.service;

import com.obrasliterarias.elasticsearch.dto.ObraLiterariaDto;
import org.springframework.data.domain.Limit;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IObraLiterariaService {
    ObraLiterariaDto save(ObraLiterariaDto obraLiterariaDto);
    List<ObraLiterariaDto> getAll();
    List<ObraLiterariaDto> findAllByAutor(String autor);
    List<ObraLiterariaDto> findAllByTitleContains(String nombre);
    List<ObraLiterariaDto> findAllByAnioBefore(Integer anio);
    List<ObraLiterariaDto> findAllByEditorial(String editorial);
    List<ObraLiterariaDto> findAllByNumPaginasTop5();
}
