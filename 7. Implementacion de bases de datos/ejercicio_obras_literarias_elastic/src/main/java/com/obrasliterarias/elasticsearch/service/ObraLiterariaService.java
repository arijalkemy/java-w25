package com.obrasliterarias.elasticsearch.service;

import com.obrasliterarias.elasticsearch.dto.ObraLiterariaDto;
import com.obrasliterarias.elasticsearch.entity.ObraLiteraria;
import com.obrasliterarias.elasticsearch.repository.IObraLiterariaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Limit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObraLiterariaService implements IObraLiterariaService{
    IObraLiterariaRepository obraLiterariaRepository;
    private final ModelMapper mapper=new ModelMapper();

    public ObraLiterariaService(IObraLiterariaRepository obraLiterariaRepository){
        this.obraLiterariaRepository=obraLiterariaRepository;
    }

    @Override
    public ObraLiterariaDto save(ObraLiterariaDto obraLiterariaDto) {
        ObraLiteraria obraLiteraria=mapper.map(obraLiterariaDto, ObraLiteraria.class);
        obraLiterariaRepository.save(obraLiteraria);

        return obraLiterariaDto;
    }

    @Override
    public List<ObraLiterariaDto> getAll() {
        return obraLiterariaRepository.findAll().stream().map(obraLiteraria -> mapper.map(obraLiteraria, ObraLiterariaDto.class)).toList();
    }

    @Override
    public List<ObraLiterariaDto> findAllByAutor(String autor) {
        return obraLiterariaRepository.findAllByAutor(autor).stream().map(obraLiteraria -> mapper.map(obraLiteraria, ObraLiterariaDto.class)).toList();
    }

    @Override
    public List<ObraLiterariaDto> findAllByTitleContains(String nombre) {
        return obraLiterariaRepository.findAllByNombreContainingIgnoreCase(nombre).stream().map(obraLiteraria -> mapper.map(obraLiteraria, ObraLiterariaDto.class)).toList();
    }

    @Override
    public List<ObraLiterariaDto> findAllByAnioBefore(Integer anio) {
        return obraLiterariaRepository.findAllByAnioPublicacionBefore(anio).stream().map(obraLiteraria -> mapper.map(obraLiteraria, ObraLiterariaDto.class)).toList();
    }

    @Override
    public List<ObraLiterariaDto> findAllByEditorial(String editorial) {
        return obraLiterariaRepository.findAllByEditorial(editorial).stream().map(obraLiteraria -> mapper.map(obraLiteraria, ObraLiterariaDto.class)).toList();
    }

    @Override
    public List<ObraLiterariaDto> findAllByNumPaginasTop5() {
        return obraLiterariaRepository.findTop5PagesQuantity().stream().map(obraLiteraria -> mapper.map(obraLiteraria, ObraLiterariaDto.class)).toList();
    }
}
