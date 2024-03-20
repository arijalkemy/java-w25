package com.ValentinCampestri.ObrasLiterarias.service;

import com.ValentinCampestri.ObrasLiterarias.Repository.IRepositoryObraLiteraria;
import com.ValentinCampestri.ObrasLiterarias.dto.MessageDto;
import com.ValentinCampestri.ObrasLiterarias.dto.ObraLiterariaDto;
import com.ValentinCampestri.ObrasLiterarias.entity.ObraLiteraria;
import com.ValentinCampestri.ObrasLiterarias.util.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ValentinCampestri.ObrasLiterarias.util.Mapper.dtoToEntity;
import static com.ValentinCampestri.ObrasLiterarias.util.Mapper.entityToDto;

@Service
public class ServiceObraLiteraria implements IServiceObraLiteraria{
    IRepositoryObraLiteraria repository;

    public ServiceObraLiteraria(IRepositoryObraLiteraria repository) {
        this.repository = repository;
    }

    @Override
    public MessageDto cargarObras(ObraLiterariaDto dto) {
        ObraLiteraria obra = dtoToEntity(dto);
        repository.save(obra);
        return new MessageDto("Cargado correctamente");
    }

    @Override
    public MessageDto cargarObrasBatch(List<ObraLiterariaDto> listaNuevasObras) {
        List<ObraLiteraria> listaObras = listaNuevasObras.stream().map(Mapper::dtoToEntity).toList();
        repository.saveAll(listaObras);
        return new MessageDto("Obras cargadas correctamente");
    }

    @Override
    public List<ObraLiterariaDto> traerTodas() {
        List<ObraLiteraria> listaObras = repository.findBy();
        return listaObras.stream().map(Mapper::entityToDto).toList();
    }
}
