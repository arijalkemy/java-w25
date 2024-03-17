package com.obrasliterarias.service;

import com.obrasliterarias.dto.request.ObraDTO;
import com.obrasliterarias.dto.response.ResponseObraDTO;

import java.util.List;

public interface IObraService {
    List<ResponseObraDTO> getObraByAutor(String autor);

    List<ResponseObraDTO> getObraByContainsInNombre(String palabra);

    List<ResponseObraDTO> findAll();

    List<ResponseObraDTO> getObraTopPaginas();

    List<ResponseObraDTO> getObrasByAnioBefore(Integer anio);

    List<ResponseObraDTO> getObrasByEditorial(String editorial);

    String createObra(ObraDTO obraDTO);
}
