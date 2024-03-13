package meli.com.co.grupalelastic.util;

import meli.com.co.grupalelastic.dto.ObraLiterariaDto;
import meli.com.co.grupalelastic.entity.ObraLiteraria;

public class Mapper {
    public static ObraLiteraria obraLiterariaDtoToObraLiteraria(ObraLiterariaDto obraLiterariaDto){
        return new ObraLiteraria(obraLiterariaDto.getNombre()
                ,obraLiterariaDto.getAutor()
                ,obraLiterariaDto.getCantidadPaginas()
                ,obraLiterariaDto.getEditorial()
                ,obraLiterariaDto.getAnio());
    }
    public static ObraLiterariaDto obraLiterariaToObraLiterariaDto(ObraLiteraria obraLiteraria){
        return  new ObraLiterariaDto(obraLiteraria.getNombre()
                ,obraLiteraria.getAutor()
                ,obraLiteraria.getCantidadPaginas()
                ,obraLiteraria.getEditorial()
                ,obraLiteraria.getAnio());
    }
}
