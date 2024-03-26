package com.example.SegurosDeAutos.service;

import com.example.SegurosDeAutos.controller.VehiculoController;
import com.example.SegurosDeAutos.dto.RequestVehiculoDTO;
import com.example.SegurosDeAutos.dto.VehiculoDTO;
import com.example.SegurosDeAutos.entity.Vehiculo;
import com.example.SegurosDeAutos.exception.NotFoundException;
import com.example.SegurosDeAutos.repository.IVehiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class VehiculoServices implements IVehiculoServices{

    private final IVehiculoRepository vehiculoRepository;
    private final ModelMapper modelMapper;

    public VehiculoServices(IVehiculoRepository vehiculoRepository, ModelMapper mapperUtil) {
        this.vehiculoRepository = vehiculoRepository;
        this.modelMapper = mapperUtil;
    }

    @Override
    public VehiculoDTO addVehiculo(RequestVehiculoDTO vehiculoDTO) {
        Vehiculo saveVehiculo = modelMapper.map(vehiculoDTO, Vehiculo.class);
        Vehiculo savedVehiculo = vehiculoRepository.save(saveVehiculo);
        return modelMapper.map(savedVehiculo, VehiculoDTO.class);
    }

    @Override
    public VehiculoDTO getVehiculoById(Long id) {
        Vehiculo vehiculo = vehiculoRepository.findById(id).orElseThrow( () -> new NotFoundException("Vehiculo no encontrado!"));
        return modelMapper.map(vehiculo, VehiculoDTO.class);
    }

    @Override
    public List<VehiculoDTO> getVehiculos() {
        List<Vehiculo> vehiculos = vehiculoRepository.findAll();
        return vehiculos.stream().map(v -> modelMapper.map(v, VehiculoDTO.class)).toList();
    }
}
