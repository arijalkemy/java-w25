package com.bootcamp.hql.service;

import com.bootcamp.hql.exceptions.NotFoundException;
import com.bootcamp.hql.model.dto.CreateSiniestroDto;
import com.bootcamp.hql.model.dto.CreateVehiculoDto;
import com.bootcamp.hql.model.dto.LinkSiniestroDto;
import com.bootcamp.hql.model.dto.MessageDto;
import com.bootcamp.hql.model.entity.Siniestro;
import com.bootcamp.hql.model.entity.Vehiculo;
import com.bootcamp.hql.model.projection.*;
import com.bootcamp.hql.repository.interfaces.ISiniestroRepository;
import com.bootcamp.hql.repository.interfaces.IVehiculoRepository;
import com.bootcamp.hql.service.interfaces.IVehiculoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VehiculoService implements IVehiculoService {
    private final IVehiculoRepository vehiculoRepository;
    private final ISiniestroRepository siniestroRepository;
    private final ModelMapper mapper;

    public VehiculoService(IVehiculoRepository vehiculoRepository, ISiniestroRepository siniestroRepository) {
        this.vehiculoRepository = vehiculoRepository;
        this.siniestroRepository = siniestroRepository;
        this.mapper = new ModelMapper();
    }

    //Listar las patentes de todos los vehículos registrados.
    @Override
    public List<SelectPatente> getAllPatentes() {
         return vehiculoRepository.findVehiculoByPatente();
    }

    //Listar la patente y la marca de todos los vehículos ordenados por año de fabricación.
    @Override
    public List<SelectPatenteAndMarca> getAllPatentesAndMarcaByAnnoFabricacion() {

        return vehiculoRepository.findVehiculosOrderByAnnoFabricacion();
    }

    //Listar la patente de todos los vehículos que tengan más de cuatro ruedas y hayan sido fabricados en el corriente año.
    @Override
    public List<SelectPatenteByRuedasAndAnnoFabricacion> getPatenteByRuedasAndAnnoFabricacion() {
        return vehiculoRepository.findVehiculosByRuedasGreaterThanAndAnnoFabricacion(
            4,
            LocalDate.now().getYear()
        );
    }

    //Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos.
    @Override
    public List<SelectByPerdidaEconomica> getMatriculaAndMarcaAndModeloByPerdidaEconomica() {
        return vehiculoRepository.findVehiculoJoinSiniestroByPerdidaEconomicaGreaterThan(10000.0);
    }

    //Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos y mostrar a cuánto ascendió la pérdida total de todos ellos.
    @Override
    public VehiculoSiniestro getMatriculaAndMarcaAndModeloAndPerdidaTotalByPerdidaEconomica() {
        List<SelectByPerdidaEconomica> vehiculos = vehiculoRepository
            .findVehiculoJoinSiniestroByPerdidaEconomicaGreaterThan(10000.0);
        Double perdidaTotal = vehiculoRepository.findPerdidaTotalByPerdidaEconomicaGreaterThan(10000.0);
        return new VehiculoSiniestro(vehiculos, perdidaTotal);
    }

    @Override
    public MessageDto createVehiculos(List<CreateVehiculoDto> vehiculosACrear) {
        vehiculosACrear.forEach(vehiculo -> {
            vehiculoRepository.save(mapper.map(vehiculo, Vehiculo.class));
        });
        return new MessageDto("Vehiculos creados con éxito");
    }

    @Override
    public MessageDto createSiniestros(List<CreateSiniestroDto> siniestrosACrear) {
        siniestrosACrear.forEach(siniestro -> {
            siniestroRepository.save(mapper.map(siniestro, Siniestro.class));
        });
        return new MessageDto("Siniestros creados con éxito");
    }

    @Override
    public MessageDto asociarSiniestroAVehiculo(LinkSiniestroDto linkSiniestro) {
        Siniestro siniestro = siniestroRepository.findById(linkSiniestro.getIdSiniestro()).orElseThrow(
            () -> new NotFoundException("Siniestro no encontrado")
        );
        Vehiculo vehiculo = vehiculoRepository.findById(linkSiniestro.getIdVehiculo()).orElseThrow(
            () -> new NotFoundException("Vehiculo no encontrado")
        );
        vehiculo.getSiniestros().add(siniestro);
        vehiculoRepository.save(vehiculo);
        return new MessageDto("Siniestro asociado al vehículo con éxito");
    }
}
