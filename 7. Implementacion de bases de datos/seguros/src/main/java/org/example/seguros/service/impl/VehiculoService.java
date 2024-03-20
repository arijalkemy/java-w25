package org.example.seguros.service.impl;

import jakarta.transaction.Transactional;
import org.example.seguros.dto.request.VehiculoReqDTO;
import org.example.seguros.dto.response.VehiculoPatYMarcaRespDTO;
import org.example.seguros.dto.response.VehiculoRespDTO;
import org.example.seguros.entity.Vehiculo;
import org.example.seguros.repository.IVehiculoRepository;
import org.example.seguros.service.IVehiculoService;
import org.example.seguros.utils.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculoService implements IVehiculoService {

    private final IVehiculoRepository vehiculoRepository;

    public VehiculoService(IVehiculoRepository vehiculoRepository){
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    @Transactional
    public VehiculoRespDTO crearVehiculo(VehiculoReqDTO vehiculoDTO) {
        return Mapper.vehiculoToRespDTO(vehiculoRepository.save(Mapper.VehiculoReqDTOToVehiculo(vehiculoDTO)));
    }

    @Override
    @Transactional
    public VehiculoRespDTO getVehiculoById(Long id) {
        Optional<Vehiculo> optVehiculo = vehiculoRepository.findById(id);

        if (optVehiculo.isEmpty()) {
            throw new RuntimeException("No se encontró el vehículo con el id " + id);
        }

        return Mapper.vehiculoToRespDTO(optVehiculo.get());
    }

    @Override
    @Transactional
    public List<String> findAllPatentes(){
        return vehiculoRepository.findAllPatentes();
    }

    @Override
    @Transactional
    public List<VehiculoPatYMarcaRespDTO> findAllPatentesAndMarcaOrderByAnioFabricacion() {
        return vehiculoRepository.findAllPatentesAdMarcaOrderByAnioFabricacion().stream()
                .map(Mapper::patenteMarcaToRespDTO).toList();
    }

    @Override
    @Transactional
    public List<String> findPatentesVehiculosMasCuatroRuedasByAnioActual() {
        return vehiculoRepository.findPatentesVehiculosMasCuatroRuedasByAnioActual();
    }
}
