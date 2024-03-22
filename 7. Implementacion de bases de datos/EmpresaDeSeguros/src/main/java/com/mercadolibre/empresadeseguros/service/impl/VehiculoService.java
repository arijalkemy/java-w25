package com.mercadolibre.empresadeseguros.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.empresadeseguros.dto.request.CreateVehiculoDto;
import com.mercadolibre.empresadeseguros.dto.response.VehiculoDto;
import com.mercadolibre.empresadeseguros.entity.Vehiculo;
import com.mercadolibre.empresadeseguros.repository.IVehiculoRepository;
import com.mercadolibre.empresadeseguros.service.IVehiculoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoService implements IVehiculoService {

    private final IVehiculoRepository iVehiculoRepository;
    private final ObjectMapper objectMapper;

    public VehiculoService(IVehiculoRepository iVehiculoRepository, ObjectMapper objectMapper){
        this.iVehiculoRepository = iVehiculoRepository;
        this.objectMapper = objectMapper;
    }

    public VehiculoDto create(CreateVehiculoDto createVehiculoDto){
        Vehiculo vehiculo = objectMapper.convertValue(createVehiculoDto, Vehiculo.class);
        Vehiculo newVehiculo = this.iVehiculoRepository.save(vehiculo);
        return objectMapper.convertValue(newVehiculo, VehiculoDto.class);
    }
    public List<VehiculoDto> getAll(){
        return this.iVehiculoRepository.findAll()
                    .stream().map((v)->objectMapper.convertValue(v, VehiculoDto.class)).toList();
    }
}
