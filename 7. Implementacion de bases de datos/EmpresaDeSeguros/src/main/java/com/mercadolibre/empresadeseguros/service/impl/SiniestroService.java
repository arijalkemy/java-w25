package com.mercadolibre.empresadeseguros.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.empresadeseguros.dto.request.CreateSiniestroDto;
import com.mercadolibre.empresadeseguros.dto.response.SiniestroDto;
import com.mercadolibre.empresadeseguros.entity.Siniestro;
import com.mercadolibre.empresadeseguros.entity.Vehiculo;
import com.mercadolibre.empresadeseguros.repository.ISiniestroRepository;
import com.mercadolibre.empresadeseguros.repository.IVehiculoRepository;
import com.mercadolibre.empresadeseguros.service.ISiniestroService;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.List;
import java.util.Optional;

@Service
public class SiniestroService implements ISiniestroService {

    private final IVehiculoRepository iVehiculoRepository;
    private final ISiniestroRepository iSiniestroRepository;
    private final ObjectMapper objectMapper;

    public SiniestroService (
            IVehiculoRepository iVehiculoRepository,
            ISiniestroRepository iSiniestroRepository,
            ObjectMapper objectMapper
    ){
        this.iVehiculoRepository = iVehiculoRepository;
        this.iSiniestroRepository = iSiniestroRepository;
        this.objectMapper = objectMapper;
    }

    public SiniestroDto create(CreateSiniestroDto createSiniestroDto){
        Optional<Vehiculo> vehiculo = this.iVehiculoRepository.findById(createSiniestroDto.idVehiculo());
        if(vehiculo.isEmpty())
            throw new RuntimeException("Vehiculo no encontrado");

        Siniestro siniestro = objectMapper.convertValue(createSiniestroDto, Siniestro.class);
        siniestro.setVehiculo(vehiculo.get());
        Siniestro newSiniestro = this.iSiniestroRepository.save(siniestro);
        return objectMapper.convertValue(newSiniestro, SiniestroDto.class);
    }
    public List<SiniestroDto> getAll(){
        return this.iSiniestroRepository.findAll().stream().map((s)-> objectMapper.convertValue(s, SiniestroDto.class)).toList();
    }
}
