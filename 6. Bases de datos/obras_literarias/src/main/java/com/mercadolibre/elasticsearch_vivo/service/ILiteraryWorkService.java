package com.mercadolibre.elasticsearch_vivo.service;

import com.mercadolibre.elasticsearch_vivo.dto.CreateLiteraryWorkDto;
import com.mercadolibre.elasticsearch_vivo.dto.LiteraryWorkResponseDto;

import java.util.List;

public interface ILiteraryWorkService {
    LiteraryWorkResponseDto createLiteraryWork(CreateLiteraryWorkDto createLiteraryWorkDto);

    List<LiteraryWorkResponseDto> getAllLiteraryWorks();

    List<LiteraryWorkResponseDto> getAllLiteraryWorksByAuthor(String author);

    List<LiteraryWorkResponseDto> getAllLiteraryWorksByName(String name);

    List<LiteraryWorkResponseDto> getTop5LiteraryWorksOrderByPageCountDesc();
}
