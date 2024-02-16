package com.ejemplo.blog.util;

import com.ejemplo.blog.dto.EntradaBlogDTO;
import com.ejemplo.blog.dto.ResponseDTO;
import com.ejemplo.blog.model.EntradaBlog;

import java.util.Map;

public class Mapeador {

    public static EntradaBlog convertDTO(EntradaBlogDTO entradaBlogDTO){

        return new EntradaBlog(entradaBlogDTO.getTituloBlog(),
                entradaBlogDTO.getNombreAutor(),
                entradaBlogDTO.getFechaPublicacion());
    }

    public static ResponseDTO converEntity(EntradaBlog entradaBlog, int key){

        return new ResponseDTO(key,
                entradaBlog.getTituloBlog(),
                entradaBlog.getNombreAutor(),
                entradaBlog.getFechaPublicacion(),
                200);
    }

}
