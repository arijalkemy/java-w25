package com.example.ObrasLiterarias.service;

import com.example.ObrasLiterarias.dto.ObraLiterariaDTO;
import com.example.ObrasLiterarias.dto.ResponseDTO;

import java.util.List;

public interface IObraLiterariaService {

    List<ObraLiterariaDTO> getObraLiterariaByTitle(String keyword);

    List<ObraLiterariaDTO> getObrasLiterariasDeAutor(String name);

    List<ObraLiterariaDTO> getTopFiveMorePages();

    List<ObraLiterariaDTO> getTitlesBeforeYear(Integer year);

    List<ObraLiterariaDTO> getTitlesByEditorial(String name);

    ResponseDTO saveLiteraryWork(ObraLiterariaDTO obraLiterariaDTO);

}
