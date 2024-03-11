package com.bootcamp.joyeria.services;

import com.bootcamp.joyeria.dto.GenericResponseDTO;
import com.bootcamp.joyeria.dto.JoyaDTO;
import com.bootcamp.joyeria.model.Joya;
import com.bootcamp.joyeria.repository.IJoyeriaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoyeriaServiceImpl implements IJoyeriaService {
    @Autowired
    IJoyeriaRepository joyeriaRepository;

    @Override
    public GenericResponseDTO<Integer> save(JoyaDTO joyaDTO) {
        Joya joya = joyeriaRepository.save(mapDTOtoJoya(joyaDTO));
        return new GenericResponseDTO<>(joya.getId());
    }

    @Override
    public GenericResponseDTO<String> delete(Integer id) {
        Joya jewerlyToDelete = joyeriaRepository.findById(id).orElse(null);
        jewerlyToDelete.setVentaONo(false);
        joyeriaRepository.save(jewerlyToDelete);
        return new GenericResponseDTO<>("Joya borrada con exito");
    }

    @Override
    public GenericResponseDTO<String> update(Integer id, JoyaDTO joyaDTO) {
        Joya joya = this.mapDTOtoJoya(joyaDTO);
        joya.setId(id);
        joyeriaRepository.save(joya);
        return new GenericResponseDTO<>("joya modificada con exito");
    }

    @Override
    public List<JoyaDTO> findAll() {
        return joyeriaRepository.findAll().stream().filter(Joya::isVentaONo).map(this::mapWithModelJoyatoDTO).toList();
    }

    private Joya mapDTOtoJoya(JoyaDTO joyadto) {
        return new Joya(joyadto.getNombre(), joyadto.getMaterial(), joyadto.getPeso(), joyadto.getParticularidad(), joyadto.isPosee_piedra(), joyadto.isVentaONo());
    }
    private JoyaDTO mapJoyatoDto(Joya joya){
        return new JoyaDTO(joya.getNombre(), joya.getMaterial(), joya.getPeso(), joya.getParticularidad(), joya.isPosee_piedra(), joya.isVentaONo());
    }
    private JoyaDTO mapWithModelJoyatoDTO(Joya joya){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(joya, JoyaDTO.class);
    }
}
