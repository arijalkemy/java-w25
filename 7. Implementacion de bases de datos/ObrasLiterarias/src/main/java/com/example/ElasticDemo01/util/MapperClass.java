package com.example.ElasticDemo01.util;

import com.example.ElasticDemo01.dto.ObraDto;
import com.example.ElasticDemo01.entity.Obra;

public class MapperClass {
    public static Obra dtoToEntity(ObraDto obraDto){
        return new Obra(
                obraDto.getNombre(),
                obraDto.getAutor(),
                obraDto.getCantidad_paginas(),
                obraDto.getEditorial(),
                obraDto.getAnio());
    }

    public static ObraDto entityToDto(Obra obra){
        return new ObraDto(
                obra.getNombre(),
                obra.getAutor(),
                obra.getCantidad_paginas(),
                obra.getEditorial(),
                obra.getAnio());
    }
}
