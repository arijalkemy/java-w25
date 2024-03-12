package com.mercadolibre.hql_seguro_autos.service;

import com.mercadolibre.hql_seguro_autos.dto.request.CreateVehiculoDto;
import com.mercadolibre.hql_seguro_autos.dto.response.*;
import com.mercadolibre.hql_seguro_autos.entity.Vehiculo;
import com.mercadolibre.hql_seguro_autos.repository.VehiculoRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculoService implements IVehiculoService {
    private final VehiculoRepository repository;
    private final ModelMapper mapper = new ModelMapper();

    @Override
    public VehicleDto create(CreateVehiculoDto createVehiculoDto) {
        Vehiculo newVehicle = mapper.map(createVehiculoDto, Vehiculo.class);
        newVehicle.getSiniestros().forEach(siniestro -> siniestro.setVehiculo(newVehicle));
        return mapper.map(repository.save(newVehicle), VehicleDto.class);
    }

    @Override
    public List<PatenteDto> findAllPatentes() {
        List<String> patentes = repository.findAllPatentes();
        List<PatenteDto> patenteDtos = new ArrayList<>();

        for (String p : patentes) {
            patenteDtos.add(new PatenteDto(p));
        }

        return patenteDtos;
    }

    @Override
    public List<PatenteMarcaDto> findPatenteAndMarcaOrderByAnioFabricacion() {
        return repository.findPatenteAndMarcaOrderByAnioFabricacion().stream()
                .map(patenteMarca -> new PatenteMarcaDto(patenteMarca.getPatente(), patenteMarca.getMarca()))
                .toList();
    }

    @Override
    public List<PatenteDto> findPatentesWithMoreThan4WheelsAndCurrentYear() {
        return repository.findPatenteAndMarcaByCantidadRuedasGreaterThanAndAnioFabricacionEquals(4, LocalDate.now().getYear()).stream()
                .map(PatenteDto::new)
                .toList();
    }

    @Override
    public List<PatenteMarcaModeloDto> findMarcaPatenteModeloWithSiniestrosWithPerdidasGreaterThan10000() {
        return repository.findMarcasPatentesModelosWithSiniestrosWithPerdidasGreaterThan(10000.0).stream()
                .map(patenteMarcaModelo -> new PatenteMarcaModeloDto(
                        patenteMarcaModelo.getPatente(),
                        patenteMarcaModelo.getMarca(),
                        patenteMarcaModelo.getModelo())
                )
                .toList();
    }

    @Override
    public VehiculoSiniestroDto findPerdidasSumMarcasPatentesModelosWithSiniestrosWithPerdidasGreaterThan10000() {
        return new VehiculoSiniestroDto(repository.findPerdidasSumMarcasPatentesModelosWithSiniestrosWithPerdidasGreaterThan(10000.0).stream()
                .map(perdidasEconomicas -> new PerdidaEconomicaDto(
                        new PatenteMarcaModeloDto(perdidasEconomicas.getPatente(), perdidasEconomicas.getMarca(), perdidasEconomicas.getModelo()),
                        perdidasEconomicas.getPerdidaTotal()
                ))
                .toList());
    }
}