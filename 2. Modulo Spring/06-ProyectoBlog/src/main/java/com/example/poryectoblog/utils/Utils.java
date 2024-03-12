package com.example.poryectoblog.utils;

import com.example.poryectoblog.dto.EntradaBlogDto;
import com.example.poryectoblog.entity.EntradaBlog;

public class Utils {

    public static EntradaBlog entradaBlogDtoToEntity(EntradaBlogDto entradaBlogDto){

        EntradaBlog entradaBlog = new EntradaBlog();

        entradaBlog.setId(entradaBlogDto.getId());
        entradaBlog.setAuthor(entradaBlogDto.getAuthor());
        entradaBlog.setTitle(entradaBlogDto.getTitle());
        entradaBlog.setPublicationDate(entradaBlogDto.getPublicationDate());

        return entradaBlog;
    }


    public static EntradaBlogDto entradaBlogEntityToDto(EntradaBlog entradaBlog){

        EntradaBlogDto entradaBlogDto = new EntradaBlogDto();

        entradaBlogDto.setId(entradaBlog.getId());
        entradaBlogDto.setAuthor(entradaBlog.getAuthor());
        entradaBlogDto.setTitle(entradaBlog.getTitle());
        entradaBlogDto.setPublicationDate(entradaBlog.getPublicationDate());

        return entradaBlogDto;
    }


}
