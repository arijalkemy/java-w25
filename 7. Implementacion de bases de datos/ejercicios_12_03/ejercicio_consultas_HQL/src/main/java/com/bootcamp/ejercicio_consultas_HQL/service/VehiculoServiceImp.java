package com.bootcamp.ejercicio_consultas_HQL.service;

import com.bootcamp.ejercicio_consultas_HQL.dto.request.ReqVehiculoDTO;
import com.bootcamp.ejercicio_consultas_HQL.dto.response.*;
import com.bootcamp.ejercicio_consultas_HQL.entity.Vehiculo;
import com.bootcamp.ejercicio_consultas_HQL.repository.IVehiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class VehiculoServiceImp implements IVehiculoService{
    private final IVehiculoRepository vehiculoRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public VehiculoServiceImp(IVehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    public ResponseDTO createVehiculo(ReqVehiculoDTO reqVehiculoDTO) {
        Vehiculo vehiculo = modelMapper.map(reqVehiculoDTO, Vehiculo.class);
        vehiculoRepository.save(vehiculo);
        return new ResponseDTO("Vehiculo creado exitosamente.");
    }

    @Override
    public List<ResVehiculoDTO> getAllVehiculos() {
        List<Vehiculo> vehiculos = vehiculoRepository.findAll();
        return vehiculos.stream()
                .map(vehiculo -> modelMapper.map(vehiculo, ResVehiculoDTO.class))
                .toList();
    }

    @Override
    public ResVehiculoDTO getById(Long id) {
        Optional<Vehiculo> vehiculo = vehiculoRepository.findById(id);
        if (vehiculo.isEmpty()) {
            throw new RuntimeException("Vehiculo no encontrado.");
        }
        return modelMapper.map(vehiculo.get(), ResVehiculoDTO.class);
    }

    @Override
    public List<PatenteDTO> getAllPatentes() {
        List<Vehiculo> vehiculos = vehiculoRepository.findAll();
        return vehiculos.stream()
                .map(vehiculo -> modelMapper.map(vehiculo, PatenteDTO.class))
                .toList();
    }

    @Override
    public List<PatenteYMarcaDTO> getAllPatenteYMarcaOrdenados() {
        List<Vehiculo> vehiculos = vehiculoRepository.findAllByOrderByAnyoFabricacion();
        return vehiculos.stream()
                .map(vehiculo -> modelMapper.map(vehiculo, PatenteYMarcaDTO.class))
                .toList();
    }

    @Override
    public List<PatenteDTO> getAllPatenteThisYear() {
        List<Vehiculo> vehiculos = vehiculoRepository.findAllByAnyoFabricacion(LocalDate.now().getYear());
        return vehiculos.stream()
                .filter(vehiculo -> vehiculo.getCantidadRuedas() > 4)
                .map(vehiculo -> modelMapper.map(vehiculo, PatenteDTO.class))
                .toList();
    }

    @Override
    public List<PatenteMarcaModeloDTO> getAllPatenteMarcaModelo() {
        List<Vehiculo> vehiculos = vehiculoRepository.findAllBySiniestrosAndPerdidaDiezMil();
        return vehiculos.stream()
                .map(vehiculo -> modelMapper.map(vehiculo, PatenteMarcaModeloDTO.class))
                .toList();
    }

    @Override
    public List<PatenteMarcaModeloPerdidaTotalDTO> getAllPatenteMarcaModeloPerdidaTotal() {
        List<Vehiculo> vehiculos = vehiculoRepository.findAllBySiniestrosAndPerdidaDiezMil();
        List<PatenteMarcaModeloPerdidaTotalDTO> vehiculosResponse = vehiculos.stream()
                .map(vehiculo -> modelMapper.map(vehiculo, PatenteMarcaModeloPerdidaTotalDTO.class))
                .toList();
        vehiculosResponse.forEach(vehiculo -> {
            vehiculo.setPerdidaTotal(vehiculoRepository.sumPerdidaEconomicaByVehiculoId(vehiculo.getVehiculoId()));
        });

        return vehiculosResponse;
    }
}
