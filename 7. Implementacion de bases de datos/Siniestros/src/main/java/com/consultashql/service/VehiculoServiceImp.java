package com.consultashql.service;

import com.consultashql.DTO.VehiculoDTO;
import com.consultashql.DTO.VehiculoSiniestroDTO;
import com.consultashql.DTO.response.PatentesDTO;
import com.consultashql.DTO.response.PatentesMarcaDTO;
import com.consultashql.model.Vehiculo;
import com.consultashql.repository.IVehiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehiculoServiceImp implements  IVehiculoService{
    ModelMapper modelMapper;
    double totalPerdidas = 0;
    IVehiculoRepository vehiculoRepository;
    public VehiculoServiceImp(IVehiculoRepository vehiculoRepository){
        this.modelMapper = new ModelMapper();
        this.vehiculoRepository = vehiculoRepository;
    }
    @Override
    public VehiculoDTO addNewVehiculo(VehiculoDTO vehiculoDTO) {
        Vehiculo vehiculo = vehiculoRepository.save(modelMapper.map(vehiculoDTO, Vehiculo.class));
        return modelMapper.map(vehiculo, VehiculoDTO.class);
    }


    //listar las patentes de todos los vehiculos
    @Override
    public PatentesDTO getVehiculos() {

        PatentesDTO patentesDTO = new PatentesDTO();
        patentesDTO.setPatentes( vehiculoRepository.findAll().stream()
                .map(Vehiculo::getPatente)
                .toList());
        return patentesDTO;

    }

    @Override
    public List<PatentesMarcaDTO> getPatenteMarca() {
      List<Vehiculo> vehiculoList = vehiculoRepository.findVehiculosOrderedByAnio();

        return vehiculoList.stream()
                .map(v -> new PatentesMarcaDTO(v.getPatente(), v.getMarca(), v.getAnio()))
                .collect(Collectors.toList());

     }

    public VehiculoSiniestroDTO getVehiculoSiniestro(String x){
        totalPerdidas = 0;
        List<Vehiculo> vehiculoList = vehiculoRepository.findVehicleByLossGreaterThan(10000D);
        vehiculoList
                .forEach(vehi -> vehi.getSiniestros()
                        .forEach(sinies -> totalPerdidas += sinies.getPerdida_economica()
                        )
                );
        List<VehiculoDTO> vehiculoDTO = vehiculoList.stream().map(vehiculo -> modelMapper.map(vehiculo, VehiculoDTO.class)).toList();
        if (!x.equals("none")){
            return null;
        }
        return new VehiculoSiniestroDTO(vehiculoDTO, totalPerdidas);
    }

    public PatentesDTO getRuedasAnio(){
        List<Vehiculo> vehiculoList = vehiculoRepository.findVehiculoByAnioAndCantidadRuedas();
        return new PatentesDTO(vehiculoList.stream().map(Vehiculo::getPatente).toList());
    }

    @Override
    public Vehiculo getVehiculoById(Long vehiculoDenunciado) {
        return vehiculoRepository.findById(vehiculoDenunciado).orElse(null);
    }

    ;
}
