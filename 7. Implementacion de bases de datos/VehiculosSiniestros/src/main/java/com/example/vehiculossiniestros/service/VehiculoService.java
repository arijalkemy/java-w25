package com.example.vehiculossiniestros.service;

import com.example.vehiculossiniestros.dto.PatenteMarcaDto;
import com.example.vehiculossiniestros.dto.PatenteMarcaModeloDto;
import com.example.vehiculossiniestros.dto.VehiculoDto;
import com.example.vehiculossiniestros.dto.VehiculoSiniestroDto;
import com.example.vehiculossiniestros.entity.Siniestro;
import com.example.vehiculossiniestros.entity.Vehiculo;
import com.example.vehiculossiniestros.repository.IVehiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehiculoService implements IVehiculoService {

  @Autowired
  IVehiculoRepository vehiculoRepository;

  @Autowired
  private ModelMapper mapper;

  @Override
  public VehiculoDto createVehicle(VehiculoDto vehiculoDto) {
    Vehiculo vehiculo = mapper.map(vehiculoDto, Vehiculo.class);
    vehiculo.getSiniestros().forEach(s-> s.setVehiculo_denunciado(vehiculo));
    vehiculoRepository.save(vehiculo);
    return vehiculoDto;
  }

  @Override
  public List<VehiculoDto> getAllVehicles() {
    return vehiculoRepository.findAll().stream().map(
        vehiculo -> mapper.map(vehiculo, VehiculoDto.class)
    ).toList();
  }

  @Override
  public List<String> getAllPatents() {
    return this.vehiculoRepository.getAllPatentes();
  }

  @Override
  public List<PatenteMarcaDto> getAllPatentsAndBrands() {
    return vehiculoRepository.findAll().stream().map(
        vehiculo -> mapper.map(vehiculo, PatenteMarcaDto.class)
    ).toList();
  }

  @Override
  public List<String> getFourWheelsAndCurrentYearVehicles() {
    return vehiculoRepository.findFourWheelsAndCurrentYearVehicles(LocalDate.now().getYear())
        .stream().map(Vehiculo::getPatente).toList();
  }

  @Override
  public List<PatenteMarcaModeloDto> getMajorsSinisterInfo() {
    return vehiculoRepository.findAll().stream()
        .filter(
            vehiculo -> vehiculo.getSiniestros().stream().anyMatch(
                siniestro -> siniestro.getPerdida_economica() >= 10000
            )
        )
        .map(
            vehiculo -> mapper.map(vehiculo, PatenteMarcaModeloDto.class)
        ).toList();
  }

  @Override
  public List<VehiculoSiniestroDto> getMajorsSinisterFullInfo() {
    return vehiculoRepository.findAll().stream()
        .filter(
            vehiculo -> vehiculo.getSiniestros().stream().anyMatch(
                siniestro -> siniestro.getPerdida_economica() >= 10000
            )
        ).map(
            vehiculo -> new VehiculoSiniestroDto(
                mapper.map(vehiculo,PatenteMarcaModeloDto.class),
                vehiculo.getSiniestros().stream().mapToInt(Siniestro::getPerdida_economica).sum()
            )
        ).toList();
  }
}
