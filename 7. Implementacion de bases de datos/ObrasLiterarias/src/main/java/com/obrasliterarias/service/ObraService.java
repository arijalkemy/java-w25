package com.obrasliterarias.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.obrasliterarias.dto.request.ObraDTO;
import com.obrasliterarias.dto.response.ResponseObraDTO;
import com.obrasliterarias.repository.IObraRepository;
import com.obrasliterarias.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class ObraService implements IObraService{
    private final IObraRepository obraRepository;

    public ObraService(IObraRepository obraRepository){
        this.obraRepository = obraRepository;
    }
    @Override
    public List<ResponseObraDTO> getObraByAutor(String autor) {
        return obraRepository.findObraLiterariaByAutor(autor)
                .stream().map(Mapper::obraToObraDTO).toList();
    }

    @Override
    public List<ResponseObraDTO> getObraByContainsInNombre(String palabra) {
        return obraRepository.findObraLiterariaByNombreContaining(palabra)
                .stream().map(Mapper::obraToObraDTO).toList();
    }

    @Override
    public List<ResponseObraDTO> findAll() {
        return obraRepository.findAll().stream().map(Mapper::obraToObraDTO).toList();
    }

    @Override
    public List<ResponseObraDTO> getObraTopPaginas() {
        return obraRepository.findTop5ByOrderByPaginasDesc().stream().map(Mapper::obraToObraDTO).toList();
    }

    @Override
    public List<ResponseObraDTO> getObrasByAnioBefore(Integer anio) {
        return obraRepository.findObraLiterariaByAnioBefore(anio).stream().map(Mapper::obraToObraDTO).toList();
    }

    @Override
    public List<ResponseObraDTO> getObrasByEditorial(String editorial) {
        return obraRepository.findObraLiterariaByEditorial(editorial).stream().map(Mapper::obraToObraDTO).toList();
    }

    @Override
    public String createObra(ObraDTO obraDTO) {
        obraRepository.save(Mapper.ObraDTOtoObra(obraDTO));
        return "Se creo con exito";
    }
}
