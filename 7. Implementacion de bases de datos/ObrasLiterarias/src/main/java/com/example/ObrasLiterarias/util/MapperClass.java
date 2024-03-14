package com.example.ObrasLiterarias.util;

import com.example.ObrasLiterarias.dto.ObraLiterariaDto;
import com.example.ObrasLiterarias.entity.ObraLiteraria;

public class MapperClass {
    public static ObraLiteraria dtoToEntity(ObraLiterariaDto obraLiterariaDto){
        return new ObraLiteraria(obraLiterariaDto.getNombre()
                ,obraLiterariaDto.getAutor()
                ,obraLiterariaDto.getCantidadPaginas()
                ,obraLiterariaDto.getEditorial()
                ,obraLiterariaDto.getAnioPublicacion());
    }

    public static ObraLiterariaDto entityToDto(ObraLiteraria obraLiteraria){
        return new ObraLiterariaDto(obraLiteraria.getNombre()
        ,obraLiteraria.getAutor()
        ,obraLiteraria.getCantidadPaginas()
        ,obraLiteraria.getEditorial()
        ,obraLiteraria.getAnioPublicacion());
    }
}
