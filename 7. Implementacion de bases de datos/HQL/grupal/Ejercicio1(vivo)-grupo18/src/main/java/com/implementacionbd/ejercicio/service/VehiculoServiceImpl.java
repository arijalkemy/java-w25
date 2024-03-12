package com.implementacionbd.ejercicio.service;

import com.implementacionbd.ejercicio.models.Vehiculo;
import com.implementacionbd.ejercicio.repository.IVehiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

    IVehiculoRepository iVehiculoRepository;

    public VehiculoServiceImpl(IVehiculoRepository iVehiculoRepository) {
        this.iVehiculoRepository = iVehiculoRepository;
    }

    public List<Vehiculo> findAllVehicles(){
        List<Vehiculo> listaVehiculos = iVehiculoRepository.findAllVehicles();
        return listaVehiculos;
    };

}
