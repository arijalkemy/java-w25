package com.mercadolibre.elasticsearch_vivo.service;

import com.mercadolibre.elasticsearch_vivo.dto.CreateLiteraryWorkDto;
import com.mercadolibre.elasticsearch_vivo.dto.LiteraryWorkResponseDto;
import com.mercadolibre.elasticsearch_vivo.entity.LiteraryWork;
import com.mercadolibre.elasticsearch_vivo.repository.ILiteraryWorkRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Arrays.stream;

@Service
@RequiredArgsConstructor
public class LiteraryWorkService implements ILiteraryWorkService{
    private final ILiteraryWorkRepository repository;
    private final ModelMapper mapper = new ModelMapper();
    @Override
    public LiteraryWorkResponseDto createLiteraryWork(CreateLiteraryWorkDto createLiteraryWorkDto){
        LiteraryWork newLiteraryWork = mapper.map(createLiteraryWorkDto, LiteraryWork.class);
        return mapper.map(repository.save(newLiteraryWork), LiteraryWorkResponseDto.class);
    }
    @Override
    public List<LiteraryWorkResponseDto> getAllLiteraryWorks(){
        return repository.findAll().stream()
                .map(literaryWork -> mapper.map(literaryWork, LiteraryWorkResponseDto.class))
                .toList();
    }
    @Override
    public List<LiteraryWorkResponseDto> getAllLiteraryWorksByAuthor(String author){
        return repository.findLiteraryWorksByAuthor(author).stream()
                .map(literaryWork -> mapper.map(literaryWork, LiteraryWorkResponseDto.class))
                .toList();
    }
    @Override
    public List<LiteraryWorkResponseDto> getAllLiteraryWorksByName(String name){
        return repository.findLiteraryWorksByNameContaining(name).stream()
                .map(literaryWork -> mapper.map(literaryWork, LiteraryWorkResponseDto.class))
                .toList();
    }
    @Override
    public List<LiteraryWorkResponseDto> getTop5LiteraryWorksOrderByPageCountDesc(){
        return repository.findFirst5ByOrderByPageCountDesc().stream()
                .map(literaryWork -> mapper.map(literaryWork, LiteraryWorkResponseDto.class))
                .toList();
    }
}
