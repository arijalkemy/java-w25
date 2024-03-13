package com.example.hqlsegurosvehiculos.service.impl;

import com.example.hqlsegurosvehiculos.dto.response.PatenteAndYearDTO;
import com.example.hqlsegurosvehiculos.dto.response.PatentesDTO;
import com.example.hqlsegurosvehiculos.dto.response.SiniestrosDTO;
import com.example.hqlsegurosvehiculos.dto.response.VehiculoDTO;
import com.example.hqlsegurosvehiculos.dto.request.NuevoVehiculoDTO;
import com.example.hqlsegurosvehiculos.entity.PatenteAndYear;
import com.example.hqlsegurosvehiculos.entity.Siniestro;
import com.example.hqlsegurosvehiculos.entity.Vehiculo;
import com.example.hqlsegurosvehiculos.exception.BadRequestException;
import com.example.hqlsegurosvehiculos.repository.IVehiculoRepository;
import com.example.hqlsegurosvehiculos.service.IVehiculoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

    @Autowired
    IVehiculoRepository repository;

    ModelMapper mapper = new ModelMapper();
    public List<PatenteAndYearDTO> getAllPatentesOrderbyYearFab() {
        List<Object[]> listPatentes = repository.findAllByOrderByYearFabricacionAsc();
        if (listPatentes.isEmpty()){
            throw new BadRequestException("No se encuentran vehiculos cargados");
        }
        return listPatentes.stream()
                .map(patente -> new PatenteAndYearDTO((String) patente[0],
                        (String) patente[1],
                        (Integer) patente[2]))
                .toList();
    }

    @Override
    public List<PatenteAndYearDTO> getAllVehiclesMoreThan4Wheels() {
        List<Object[]> listPatentes = repository.findAllByCantRuedasGreaterThan4();
        if (listPatentes.isEmpty()){
            throw new BadRequestException("No se encuentran vehiculos cargados");
        }
        return listPatentes.stream()
                .map(patente -> new PatenteAndYearDTO(
                        (String) patente[0],
                        (String) patente[1],
                        (Integer) patente[2]))
                .toList();
    }

    @Override
    public List<PatentesDTO> findAllPatentes() {
        List<PatentesDTO> allPatentes = repository.findAllPatentes().stream()
                .map(patente -> new PatentesDTO(patente))
                .toList();
        if (allPatentes.isEmpty()){
            throw new BadRequestException("No se encuentran vehiculos cargados");
        }
        return allPatentes;
    }

    @Override
    public List<VehiculoDTO> findAll() {
        return repository.findAll().stream()
                .map(vehiculo -> mapper.map(vehiculo, VehiculoDTO.class))
                .toList();
    }

    public List<SiniestrosDTO> findAllSiniestros() {
        List<Siniestro> allSiniestros = repository.findAllSiniestros();
        if (allSiniestros.isEmpty()){
            throw new BadRequestException("No se encuentran siniestros cargados");
        }
        return allSiniestros.stream()
                .map(siniestro -> mapper.map(siniestro, SiniestrosDTO.class))
                .toList();
    }

    @Override
    public NuevoVehiculoDTO create(NuevoVehiculoDTO vehiculoDTO) {
        Vehiculo vehiculo = mapper.map(vehiculoDTO, Vehiculo.class);
        setVehiculoForSiniestros(vehiculo);
        return mapper.map(repository.save(vehiculo), NuevoVehiculoDTO.class);
    }

    private void setVehiculoForSiniestros(Vehiculo vehiculo) {
        if (vehiculo.getSiniestros() != null) {
            vehiculo.getSiniestros().forEach(siniestro -> siniestro.setVehiculo(vehiculo));
        }
    }

}
