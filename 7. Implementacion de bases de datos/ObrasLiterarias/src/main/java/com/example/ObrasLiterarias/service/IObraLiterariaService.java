package com.example.ObrasLiterarias.service;

import com.example.ObrasLiterarias.dto.ObraLiterariaDto;

import java.util.List;

public interface IObraLiterariaService {
    List<ObraLiterariaDto> findAll();
    List<ObraLiterariaDto> findObrasByAuthor(String author);
    List<ObraLiterariaDto> findObrasByTitle(String title);
    List<ObraLiterariaDto> findObrasByQuantityPages();
    ObraLiterariaDto saveObraLiteraria(ObraLiterariaDto obraLiterariaDto);
    List<ObraLiterariaDto> findAllByAnioPublicacionBefore (int year);
    List<ObraLiterariaDto> findAllByEditorial (String editorial);
}
