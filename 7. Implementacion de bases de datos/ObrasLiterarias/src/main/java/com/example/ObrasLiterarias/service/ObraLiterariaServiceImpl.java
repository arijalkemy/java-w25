package com.example.ObrasLiterarias.service;

import com.example.ObrasLiterarias.dto.ObraLiterariaDto;
import com.example.ObrasLiterarias.entity.ObraLiteraria;
import com.example.ObrasLiterarias.repository.IObraLiterariaRepository;
import com.example.ObrasLiterarias.util.MapperClass;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ObraLiterariaServiceImpl implements IObraLiterariaService{

    private IObraLiterariaRepository repository;

    public ObraLiterariaServiceImpl(IObraLiterariaRepository repository){
        this.repository = repository;
    }
    @Override
    public List<ObraLiterariaDto> findAll() {
        return repository.findAll().stream().map(MapperClass::entityToDto).toList();
    }

    @Override
    public List<ObraLiterariaDto> findObrasByAuthor(String author) {
        return repository.findAllByAutor(author).stream().map(MapperClass::entityToDto).toList();
    }

    @Override
    public List<ObraLiterariaDto> findObrasByTitle(String title) {
        return repository.findAllByNombre(title).stream().map(MapperClass::entityToDto).toList();
    }

    @Override
    public List<ObraLiterariaDto> findObrasByQuantityPages() {
        return repository.findTop5OrderByCantidadPaginas().stream().map(MapperClass::entityToDto).toList();
    }

    @Override
    public ObraLiterariaDto saveObraLiteraria(ObraLiterariaDto obraLiterariaDto) {
        ObraLiteraria obraLiteraria = MapperClass.dtoToEntity(obraLiterariaDto);
        return MapperClass.entityToDto(repository.save(obraLiteraria));
    }

    @Override
    public List<ObraLiterariaDto> findAllByAnioPublicacionBefore(int year) {
        return repository.findAllByAnioPublicacionBefore(year).stream().map(MapperClass::entityToDto).toList();
    }

    @Override
    public List<ObraLiterariaDto> findAllByEditorial(String editorial) {
        return repository.findAllByEditorial(editorial).stream().map(MapperClass::entityToDto).toList();
    }
}
