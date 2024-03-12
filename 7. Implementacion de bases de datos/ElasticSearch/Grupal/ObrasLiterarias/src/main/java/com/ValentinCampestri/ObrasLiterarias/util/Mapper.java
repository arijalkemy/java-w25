package com.ValentinCampestri.ObrasLiterarias.util;

import com.ValentinCampestri.ObrasLiterarias.dto.ObraLiterariaDto;
import com.ValentinCampestri.ObrasLiterarias.entity.ObraLiteraria;

public class Mapper {
    public static ObraLiteraria dtoToEntity(ObraLiterariaDto obraLiterariaDto){
        return new ObraLiteraria(obraLiterariaDto.getNombre()
                ,obraLiterariaDto.getAutor()
                ,obraLiterariaDto.getCantidadDePaginas()
                ,obraLiterariaDto.getEditorial()
                ,obraLiterariaDto.getAnioPrimerPublicacion());
    }
}
