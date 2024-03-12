package com.bootcamp.ejercicio_vehiculos_siniestros.service;

import com.bootcamp.ejercicio_vehiculos_siniestros.dto.response.PatenteDTO;
import com.bootcamp.ejercicio_vehiculos_siniestros.dto.response.PatenteMarcaDTO;
import com.bootcamp.ejercicio_vehiculos_siniestros.dto.response.PatenteMarcaModeloDTO;
import com.bootcamp.ejercicio_vehiculos_siniestros.dto.response.PerdidaTotalDTO;
import com.bootcamp.ejercicio_vehiculos_siniestros.model.Siniestro;
import com.bootcamp.ejercicio_vehiculos_siniestros.model.Vehiculo;
import com.bootcamp.ejercicio_vehiculos_siniestros.repository.IVehiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Service
public class VehiculoServiceImpl implements IVehiculoService {
    @Autowired
    IVehiculoRepository vehiculoRepository;
    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<PatenteDTO> getPatentes() {
        return vehiculoRepository.findAll().stream().map(vehiculo -> {
                    return modelMapper.map(vehiculo, PatenteDTO.class);
                }
        ).toList();
    }

    @Override
    public List<PatenteMarcaDTO> getPatenteAndMarca() {
        return vehiculoRepository.findAll().stream()
                .sorted(Comparator.comparing(Vehiculo::getAnioFabricacion)).map(vehiculo -> modelMapper.map(vehiculo, PatenteMarcaDTO.class)).toList();
    }

    @Override
    public List<PatenteDTO> getPatentesMoreThanFourWheelsThisYear() {
        return this.vehiculoRepository
                .getVehiculoByNumberOfWheelsAndYear(LocalDate.now().getYear())
                .stream()
                .map(vehiculo -> modelMapper.map(vehiculo, PatenteDTO.class))
                .toList();
    }

    public List<PatenteMarcaModeloDTO> getSiniestroPerdida() {
        return this.vehiculoRepository.getVehiculoDataByEconomicLossGreaterThan10000().stream().map(vehiculo -> modelMapper.map(vehiculo, PatenteMarcaModeloDTO.class)).toList();
    }

    @Override
    public List<PerdidaTotalDTO> getPerdidatotal() {
        return this.vehiculoRepository.getVehiculoDataByEconomicLossGreaterThan10000().stream().map(vehiculo ->
                new
                        PerdidaTotalDTO(new
                        PatenteMarcaModeloDTO(vehiculo.getPatente(), vehiculo.getMarca(), vehiculo.getModelo()), vehiculo.getSiniestros().stream().filter(siniestro -> siniestro.getPerdidaEconomica() > 10000).mapToDouble(Siniestro::getPerdidaEconomica).sum())
        ).toList();
    }
}
