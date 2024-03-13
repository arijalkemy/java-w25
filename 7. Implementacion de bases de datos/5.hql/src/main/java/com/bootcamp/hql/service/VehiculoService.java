package com.bootcamp.hql.service;

import com.bootcamp.hql.dto.MatriculaMarcaModeloDto;
import com.bootcamp.hql.dto.PatenteMarcaDto;
import com.bootcamp.hql.dto.PatentesDto;
import com.bootcamp.hql.model.Vehiculo;
import com.bootcamp.hql.model.VehiculoSiniestro;
import com.bootcamp.hql.repository.interfaces.IVehiculoRepository;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Service
public class VehiculoService implements IVehiculoService {

    private final IVehiculoRepository vehiculoRepository;
    private final ModelMapper modelMapper;

    public VehiculoService(IVehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public List<PatentesDto> ObtenerPatentesVehiculosRegistrados() {
        return vehiculoRepository.findVehiculos().stream()
                .map(v -> modelMapper.map(v,PatentesDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PatenteMarcaDto> ObtenerPatentesYMarcaPorAnio() {

        return vehiculoRepository.findVehiculosOrderByAnioFabricacion().stream()
                .map(v -> modelMapper.map(v,PatenteMarcaDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PatentesDto> ObtenerPatentesVehiculosMasDe4RuedasAnioActual() {
        return vehiculoRepository.findVehiculosByRuedasGreaterThanAndAnioFabricacion(4, Year.of(LocalDate.now().getYear())).stream()
                .map(v -> modelMapper.map(v,PatentesDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<MatriculaMarcaModeloDto> ObtenerMatriculaMarcaModeloVehiculoConSiniestroMayorA10000() {
        return vehiculoRepository.findVehiculoBySiniestroWithLossGreater(10000.0).stream()
                .map(v -> modelMapper.map(v, MatriculaMarcaModeloDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehiculoSiniestro> ObtenerMatriculaMarcaModeloVehiculoConSiniestroMayorA10000ConPerdidaTotal() {

        List<Object[]> results = vehiculoRepository.findVehiculoWithLossGreater(10000.0);

        List<VehiculoSiniestro> vehiculosSiniestro = new ArrayList<>();
        for (Object[] result : results) {
            String patente = (String) result[0];
            String marca = (String) result[1];
            String modelo = (String) result[2];
            double totalPerdida = (double) result[3];

            vehiculosSiniestro.add(
                    new VehiculoSiniestro(patente, marca, modelo, totalPerdida)
            );
        }

        return vehiculosSiniestro;

    }
}
