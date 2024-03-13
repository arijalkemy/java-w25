package com.example.ElasticDemo01.util;

import com.example.ElasticDemo01.dto.ObraLiterariaDTO;
import com.example.ElasticDemo01.entity.ObraLiteraria;

public class MapperClass {
    public static ObraLiteraria dtoToEntity(ObraLiterariaDTO obraLiterariaDTO){
        return new ObraLiteraria(obraLiterariaDTO.getNombre()
                ,obraLiterariaDTO.getAutor()
                , obraLiterariaDTO.getCantidadPaginas()
                ,obraLiterariaDTO.getEditorial()
                ,obraLiterariaDTO.getFechaPublicacion());
    }

    public static ObraLiterariaDTO entityToDto(ObraLiteraria obraLiteraria){
        return new ObraLiterariaDTO(obraLiteraria.getId()
                ,obraLiteraria.getNombre()
                ,obraLiteraria.getAutor()
                , obraLiteraria.getCantidadPaginas()
                ,obraLiteraria.getEditorial()
        ,obraLiteraria.getFechaPublicacion());
    }

}
