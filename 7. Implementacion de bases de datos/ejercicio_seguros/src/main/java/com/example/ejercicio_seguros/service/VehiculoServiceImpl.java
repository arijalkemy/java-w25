package com.example.ejercicio_seguros.service;

import com.example.ejercicio_seguros.dto.*;
import com.example.ejercicio_seguros.model.Siniestro;
import com.example.ejercicio_seguros.model.Vehiculo;
import com.example.ejercicio_seguros.repository.IVehiculoRepositorio;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.NamingConventions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoServiceImpl implements IVehiculoService{
    IVehiculoRepositorio vehiculoRepositorio;
    ModelMapper mapper = new ModelMapper();

    public VehiculoServiceImpl(IVehiculoRepositorio vehiculoRepositorio) {
        this.vehiculoRepositorio = vehiculoRepositorio;
        this.mapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setSourceNamingConvention(NamingConventions.JAVABEANS_MUTATOR);
    }

    @Override
    public List<VehiculoDTO> listVehiculos() {
        List<Vehiculo> vehiculos = vehiculoRepositorio.findAll();
        return vehiculos.stream().map(vehiculo -> mapper.map(vehiculo, VehiculoDTO.class)).toList();
    }

    @Override
    public MensajeDTO guardarVehiculo(VehiculoDTO vehiculoDTO) {
        Vehiculo vehiculo = mapper.map(vehiculoDTO, Vehiculo.class);
        vehiculo.setSiniestros(vehiculoDTO.getSiniestros().stream()
                .map(s -> {
                   Siniestro siniestro = new Siniestro(s.getFecha(),s.getPerdidaEconomica());
                   siniestro.setIdVehiculoDenunciado(vehiculo);
                   return siniestro;
                }).toList());
        this.vehiculoRepositorio.save(vehiculo);
        return new MensajeDTO("Vehiculo guardado con exito");
    }

    @Override
    public List<PatenteDTO> listPatentesVehiculos(){
       return this.vehiculoRepositorio.findPatentesOfVehiculos().stream()
               .map(PatenteDTO::new).toList();
    }

    @Override
    public List<PatMarcaDto> listPaMarcaVehiculos(){
        return this.vehiculoRepositorio.findPatenteAndMarcaOfVehiculosOrderByAnio().stream()
                .map(v -> new PatMarcaDto(v.getPatente(), v.getMarca())).toList();
    }

    @Override
    public List<PatMarModDTO> listPatentesVehiculosByRuedasAndAnio(Integer ruedas, Integer anio){
        return this.vehiculoRepositorio.findPatenteOfVehiculosByRuedasAndAnio(ruedas, anio).stream()
                .map(v -> new PatMarModDTO(v.getPatente(), v.getMarca(), v.getModelo())).toList();
    }

    @Override
    public List<PatMarModDTO> listVehiculoSiniestroByPerdida(double perdida){
        return this.vehiculoRepositorio.findVehiculoSiniestroOfVehiculosByPerdida(perdida).stream()
                .map(v-> new PatMarModDTO(v.getPatente(),v.getMarca(),v.getModelo())).toList();
    }

    @Override
    public List<SiniestroDTO> listVehiculoSiniestroByPerdidaTotal(double perdida){
        List<Vehiculo> vehiculos = this.vehiculoRepositorio.findVehiculoSiniestroOfVehiculosByPerdida(perdida);
        vehiculos.stream().forEach(vehiculo -> vehiculo.getSiniestros().forEach(siniestro -> System.out.println(siniestro.getPerdidaEconomica())));
        return List.of();

    }
}
