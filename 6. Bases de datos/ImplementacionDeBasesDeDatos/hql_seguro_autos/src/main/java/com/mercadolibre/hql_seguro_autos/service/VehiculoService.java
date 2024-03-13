package com.mercadolibre.hql_seguro_autos.service;

import com.mercadolibre.hql_seguro_autos.dto.request.CreateVehiculoDto;
import com.mercadolibre.hql_seguro_autos.dto.response.PatenteDto;
import com.mercadolibre.hql_seguro_autos.dto.response.PatenteMarcaDto;
import com.mercadolibre.hql_seguro_autos.dto.response.VehicleResponseDto;
import com.mercadolibre.hql_seguro_autos.entity.Vehiculo;
import com.mercadolibre.hql_seguro_autos.repository.SiniestroRepository;
import com.mercadolibre.hql_seguro_autos.repository.VehiculoRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculoService implements IVehiculoService{
    private final VehiculoRepository repository;
    private SiniestroRepository siniestroRepository;

    private final ModelMapper mapper = new ModelMapper();

    @Override
    public VehicleResponseDto create(CreateVehiculoDto createVehiculoDto) {
        Vehiculo newVehicle = mapper.map(createVehiculoDto, Vehiculo.class);
        newVehicle.getSiniestros().forEach(siniestro -> siniestro.setVehiculo(newVehicle));
        return mapper.map(repository.save(newVehicle), VehicleResponseDto.class);
    }

    @Override
    public List<PatenteDto> findAllPatentes() {
        List<String> patentes = repository.findAllPatentes();
        List<PatenteDto> patenteDtos = new ArrayList<>();

        for(String p: patentes){
            patenteDtos.add(new PatenteDto(p));
        }

        return patenteDtos;
    }

    @Override
    public List<PatenteMarcaDto> findPatenteAndMarcaOrderByAnioFabricacion() {
        return repository.findPatenteAndMarcaOrderByAnioFabricacion().stream()
                .map(vehiculo -> new PatenteMarcaDto(vehiculo.getPatente(), vehiculo.getMarca()))
                .toList();
    }

    @Override
    public List<PatenteDto> findPatentesWithMoreThan4WheelsAndCurrentYear() {
        return repository.findPatenteAndMarcaByCantidadRuedasGreaterThanAndAnioFabricacionEquals(4, LocalDate.now().getYear()).stream()
                .map(PatenteDto::new)
                .toList();
    }

//    public List<Vehiculo> findMarcaPatenteModeloWithSiniestrosWithPerdidasGreaterThan10000(){
//        repository
//    }

}
