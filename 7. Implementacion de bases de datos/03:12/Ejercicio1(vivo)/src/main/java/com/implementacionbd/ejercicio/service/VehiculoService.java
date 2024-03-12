package com.implementacionbd.ejercicio.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.implementacionbd.ejercicio.dto.MatriculaMarcaModeloDTO;
import com.implementacionbd.ejercicio.dto.MessageResDTO;
import com.implementacionbd.ejercicio.dto.PatenteDTO;
import com.implementacionbd.ejercicio.dto.PatenteMarcaDTO;
import com.implementacionbd.ejercicio.dto.PerdidaMayorDTO;
import com.implementacionbd.ejercicio.dto.VehiculoReqDTO;
import com.implementacionbd.ejercicio.models.Vehiculo;
import com.implementacionbd.ejercicio.repository.IVehiculoRepository;

@Service
public class VehiculoService implements IVehiculoService {
    private final IVehiculoRepository vehiculoRepository;

    public VehiculoService(IVehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    private Vehiculo DTOToVehiculo(VehiculoReqDTO vehiculoReqDTO) {
        return new Vehiculo(vehiculoReqDTO.getPatente(), vehiculoReqDTO.getMarca(), vehiculoReqDTO.getAnyoFabricacion(),
                vehiculoReqDTO.getCantidadRuedas(), vehiculoReqDTO.getModelo());
    }

    // 1.- Listar las patentes de todos los vehículos registrados.
    @Override
    public List<PatenteDTO> getPatentesRegistradas() {
        List<PatenteDTO> patenteDtos = new ArrayList<>();
        vehiculoRepository.findPatentes().forEach(s -> patenteDtos.add(new PatenteDTO(s)));
        return patenteDtos;
    }

    // 2.- Listar la patente y la marca de todos los vehículos ordenados por año de
    // fabricación.
    @Override
    public List<PatenteMarcaDTO> getPatentesYMarcaPorAnio() {
        return vehiculoRepository.findByPatenteAndMarcaPorAnio().stream()
                .map(vehiculo -> new PatenteMarcaDTO(vehiculo.getPatente(), vehiculo.getMarca()))
                .toList();
    }

    // 3.- Listar la patente de todos los vehículos que tengan más de cuatro ruedas
    // y hayan sido fabricados en el corriente año.
    @Override
    public List<PatenteDTO> getCuatriRuedasYAnioCorriente() {
        List<PatenteDTO> lista = new ArrayList<>();
        for (String p : vehiculoRepository.findPatentesRuedasYAnio()) {
            lista.add(new PatenteDTO(p));
        }
        return lista;
    }

    // 4.- Listar la matrícula, marca y modelo de todos los vehículos que hayan
    // tenido un siniestro con pérdida mayor de 10000 pesos.
    @Override
    public PerdidaMayorDTO getMatriculaMarcaModeloPerdidaMayorA(int i) {
        List<MatriculaMarcaModeloDTO> vehiculos = vehiculoRepository.findSiniestroMayorA(i).stream()
                .map(v -> new MatriculaMarcaModeloDTO(v.getPatente(), v.getMarca(), v.getModelo()))
                .toList();
        return new PerdidaMayorDTO(vehiculos);
    }

    // AUX.- Crear vehiculo:
    @Override
    public MessageResDTO postVehiculo(VehiculoReqDTO vehiculoReqDTO) {
        vehiculoRepository.save(DTOToVehiculo(vehiculoReqDTO));
        return new MessageResDTO("El Vehículo fue agregada correctamente");
    }

}
