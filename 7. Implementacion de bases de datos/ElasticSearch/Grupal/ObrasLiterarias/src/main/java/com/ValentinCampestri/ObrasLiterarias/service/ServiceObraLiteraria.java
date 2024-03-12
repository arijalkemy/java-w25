package com.ValentinCampestri.ObrasLiterarias.service;

import com.ValentinCampestri.ObrasLiterarias.Repository.IRepositoryObraLiteraria;
import com.ValentinCampestri.ObrasLiterarias.dto.MessageDto;
import com.ValentinCampestri.ObrasLiterarias.dto.ObraLiterariaDto;
import com.ValentinCampestri.ObrasLiterarias.entity.ObraLiteraria;
import org.springframework.stereotype.Service;

import static com.ValentinCampestri.ObrasLiterarias.util.Mapper.dtoToEntity;

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
}
