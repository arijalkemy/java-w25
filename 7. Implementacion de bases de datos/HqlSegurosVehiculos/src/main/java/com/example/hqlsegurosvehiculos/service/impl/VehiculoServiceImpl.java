package com.example.hqlsegurosvehiculos.service.impl;

import com.example.hqlsegurosvehiculos.dto.response.VehiculoDTO;
import com.example.hqlsegurosvehiculos.dto.response.request.NuevoVehiculoDTO;
import com.example.hqlsegurosvehiculos.exception.BadRequestException;
import com.example.hqlsegurosvehiculos.repository.IVehiculoRepository;
import com.example.hqlsegurosvehiculos.service.IVehiculoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

    @Autowired
    IVehiculoRepository repository;

    ModelMapper mapper = new ModelMapper();
    @Override
    public List<String> findAllPatentes() {
        List<String> lPatentes = repository.findAllPatentes();
        if (allPatentes.isEmpty()){
            throw new BadRequestException("No se encuentran vehiculos cargados");
        }
       return lPatentes;
    }

    @Override
    public List<VehiculoDTO> findAll() {
        return repository.findAll().stream()
                .map(vehiculo -> mapper.map(vehiculo, VehiculoDTO.class))
                .toList();
    }

    @Override
    public NuevoVehiculoDTO create(NuevoVehiculoDTO vehiculo) {
        return mapper.map(repository.save(vehiculo),
                VehiculoDTO.class);
    }


}
