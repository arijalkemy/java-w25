package com.example.ejercicio_lasPerlas.service;

import com.example.ejercicio_lasPerlas.dto.NoIdJoyaDTO;
import com.example.ejercicio_lasPerlas.dto.response.JoyaDTO;
import com.example.ejercicio_lasPerlas.dto.response.SaveDTO;
import com.example.ejercicio_lasPerlas.exception.NotFoundException;
import com.example.ejercicio_lasPerlas.model.Joya;
import com.example.ejercicio_lasPerlas.repository.IJoyaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JoyaServiceImpl implements IJoyaService{
    private final IJoyaRepository joyaRepository;

    public JoyaServiceImpl(IJoyaRepository joyaRepository) {
        this.joyaRepository = joyaRepository;
    }

    @Override
    public SaveDTO save(NoIdJoyaDTO noIdJoyaDTO) {
        ObjectMapper objectMapper = new ObjectMapper();
        Joya joya = objectMapper.convertValue(noIdJoyaDTO, Joya.class);

        return new SaveDTO(joyaRepository.save(joya).getNro_identificatorio());
    }

    @Override
    public List<JoyaDTO> list() {
        List<Joya> joyas = joyaRepository.findAll();
        return joyas.stream()
                .map(this::convertJoyaToDto)
                .collect(Collectors.toList());
    }

    @Override
    public void remove(Long id) {
        Optional<Joya> optionalJoya = joyaRepository.findById(id);

        if (optionalJoya.isEmpty()){
            throw new NotFoundException("No existe esa joya");
        }

        Joya joya = optionalJoya.get();
        joya.setVentaONo(false);

        joyaRepository.save(joya);
    }

    @Override
    public NoIdJoyaDTO update(Long id, NoIdJoyaDTO noIdJoyaDTO) {
        Optional<Joya> optionalJoya = joyaRepository.findById(id);

        if (optionalJoya.isEmpty()){
            throw new NotFoundException("No existe esa joya");
        }

        Joya joya = optionalJoya.get();
        joya.setVentaONo(noIdJoyaDTO.getVentaONo());
        joya.setPeso(noIdJoyaDTO.getPeso());
        joya.setNombre(noIdJoyaDTO.getNombre());
        joya.setMaterial(noIdJoyaDTO.getMaterial());
        joya.setParticularidad(noIdJoyaDTO.getParticularidad());
        joya.setPosee_piedra(noIdJoyaDTO.getPosee_piedra());
        joyaRepository.save(joya);

        return new NoIdJoyaDTO(
                joya.getNombre(),
                joya.getMaterial(),
                joya.getPeso(),
                joya.getParticularidad(),
                joya.getPosee_piedra(),
                joya.getVentaONo()
        );
    }

    private JoyaDTO convertJoyaToDto(Joya j) {
        return new JoyaDTO(
                j.getNro_identificatorio(),
                j.getNombre(),
                j.getMaterial(),
                j.getPeso(),
                j.getParticularidad(),
                j.getPosee_piedra(),
                j.getVentaONo());
    }
}
