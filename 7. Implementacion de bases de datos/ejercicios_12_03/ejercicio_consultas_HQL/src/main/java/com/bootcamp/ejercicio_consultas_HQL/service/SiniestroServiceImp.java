package com.bootcamp.ejercicio_consultas_HQL.service;

import com.bootcamp.ejercicio_consultas_HQL.dto.request.ReqSiniestroDTO;
import com.bootcamp.ejercicio_consultas_HQL.dto.response.ResSiniestroDTO;
import com.bootcamp.ejercicio_consultas_HQL.dto.response.ResponseDTO;
import com.bootcamp.ejercicio_consultas_HQL.entity.Siniestro;
import com.bootcamp.ejercicio_consultas_HQL.entity.Vehiculo;
import com.bootcamp.ejercicio_consultas_HQL.repository.ISiniestroRepository;
import com.bootcamp.ejercicio_consultas_HQL.repository.IVehiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SiniestroServiceImp implements ISiniestroService {
    private final ISiniestroRepository siniestroRepository;
    private final IVehiculoRepository vehiculoRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public SiniestroServiceImp(ISiniestroRepository siniestroRepository, IVehiculoRepository vehiculoRepository) {
        this.siniestroRepository = siniestroRepository;
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    public ResponseDTO create(ReqSiniestroDTO siniestroDTO) {
        Optional<Vehiculo> optionalVehiculo = vehiculoRepository.findById(siniestroDTO.getVehiculoId());
        if (optionalVehiculo.isEmpty()) {
            throw new RuntimeException("Vehiculo no encontrado.");
        }
        // Siniestro newSiniestro = modelMapper.map(siniestroDTO, Siniestro.class);
        // Con el model mapper no me dejaba crear más de un siniestro con el mismo vehiculo
        Siniestro newSiniestro = new Siniestro();
        newSiniestro.setFecha(siniestroDTO.getFecha());
        newSiniestro.setVehiculo(optionalVehiculo.get());
        newSiniestro.setPerdidaEconomica(siniestroDTO.getPerdidaEconomica());
        siniestroRepository.save(newSiniestro);
        return new ResponseDTO("Siniestro creado exitosamente.");
    }

    @Override
    public List<ResSiniestroDTO> getAll() {
        List<Siniestro> siniestros = siniestroRepository.findAll();
        return siniestros.stream()
                .map(siniestro -> modelMapper.map(siniestro, ResSiniestroDTO.class))
                .toList();
    }

    @Override
    public ResSiniestroDTO getById(Long id) {
        Optional<Siniestro> siniestro = siniestroRepository.findById(id);
        if (siniestro.isEmpty()) {
            throw new RuntimeException("Siniestro no encontrado.");
        }
        return modelMapper.map(siniestro.get(), ResSiniestroDTO.class);
    }
}
