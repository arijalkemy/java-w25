package com.obrasliterarias.utils;

import com.obrasliterarias.dto.request.ObraDTO;
import com.obrasliterarias.dto.response.ResponseObraDTO;
import com.obrasliterarias.model.ObraLiteraria;
import com.obrasliterarias.service.ObraService;

public class Mapper {
    public static ResponseObraDTO obraToObraDTO(ObraLiteraria obra){
        return new ResponseObraDTO(
                obra.getId(),
                obra.getNombre(),
                obra.getAutor(),
                obra.getPaginas(),
                obra.getEditorial(),
                obra.getAnio()
        );
    }
    public static ObraLiteraria ObraDTOtoObra(ObraDTO obraDTO){
        return new ObraLiteraria(
                null,
                obraDTO.getNombre(),
                obraDTO.getAutor(),
                obraDTO.getPaginas(),
                obraDTO.getEditorial(),
                obraDTO.getAnio()
        );
    }
}
