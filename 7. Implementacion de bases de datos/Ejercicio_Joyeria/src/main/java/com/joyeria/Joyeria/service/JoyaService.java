package com.joyeria.Joyeria.service;

import com.joyeria.Joyeria.dto.JoyaRequestDTO;
import com.joyeria.Joyeria.dto.JoyaResponseDTO;
import com.joyeria.Joyeria.dto.MessageDto;
import com.joyeria.Joyeria.exception.NotFoundException;
import com.joyeria.Joyeria.model.Joya;
import com.joyeria.Joyeria.repository.IJoyaRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JoyaService implements IJoyaService {

    private final IJoyaRepository joyaRepo;

    public JoyaService(IJoyaRepository joyaRepo) {
        this.joyaRepo = joyaRepo;
    }

    @Override
    @Transactional
    public String createJoya(JoyaRequestDTO joyaDto) {
        Joya joya = dtoToModel(null, joyaDto);
        joyaRepo.save(joya);
        return "Joya guardada correctamente.";
    }

    @Override
    @Transactional
    public List<Joya> getAllJoyas() {
        return joyaRepo.findAll();
    }

    @Override
    @Transactional
    public JoyaResponseDTO findJoyaById(Long id) {
        Optional<Joya> joyaOpt = joyaRepo.findById(id);
        if(joyaOpt.isEmpty()) throw new NotFoundException("No se ha encontrado la joya solicitada.");
        return modelToDto(joyaOpt.get());
    }

    @Override
    public String deleteJoya(Long id) {
        Optional<Joya> joyaOpt = joyaRepo.findById(id);
        if(joyaOpt.isEmpty()) throw new NotFoundException("No se ha encontrado la joya solicitada.");
        joyaRepo.delete(joyaOpt.get());
        return "Joya eliminada correctamente.";
    }

    @Override
    public JoyaResponseDTO updateJoya(Long id, JoyaRequestDTO joyaDto) {
        //TODO
        Optional<Joya> joyaOpt = joyaRepo.findById(id);
        if(joyaOpt.isEmpty()) throw new NotFoundException("No se ha encontrado la joya solicitada.");

        Joya joya = getJoya(joyaDto, joyaOpt);
        joyaRepo.save(joya);

        return buildJoyaResponseDto(joya);
    }

    private JoyaResponseDTO buildJoyaResponseDto(Joya joya) {
        return new JoyaResponseDTO(joya.getId(), "Se ha actualizado la Joya con ID: ", joya.getNombre(),
                joya.getMaterial(), joya.getParticularidad(), joya.getPeso(), joya.getPosee_piedra(), joya.getVentaONo()
        );
    }

    private Joya getJoya(JoyaRequestDTO joyaDto, Optional<Joya> joyaOpt) {
        Joya joya = joyaOpt.get();
        if(joyaDto.getMaterial() != null) joya.setMaterial(joyaDto.getMaterial());
        if(joyaDto.getNombre() != null) joya.setNombre(joyaDto.getNombre());
        if(joyaDto.getPeso() != null) joya.setPeso(joyaDto.getPeso());
        if(joyaDto.getPosee_piedra() != null) joya.setPosee_piedra(joyaDto.getPosee_piedra());
        if(joyaDto.getParticularidad() != null) joya.setParticularidad(joyaDto.getParticularidad());
        if(joyaDto.getVentaONo() != null) joya.setVentaONo(joyaDto.getVentaONo());
        return joya;
    }

    private Joya dtoToModel(Long id, JoyaRequestDTO joyaDto) {
        Joya joya = new Joya();
        if(id != null) joya.setId(id);
        joya.setNombre(joyaDto.getNombre());
        joya.setMaterial(joyaDto.getMaterial());
        joya.setParticularidad(joyaDto.getParticularidad());
        joya.setPeso(joyaDto.getPeso());
        joya.setPosee_piedra(joyaDto.getPosee_piedra());
        joya.setVentaONo(joyaDto.getVentaONo());
        return joya;
    }

    private JoyaResponseDTO modelToDto(Joya joya) {
        JoyaResponseDTO joyaDto = new JoyaResponseDTO();
        joyaDto.setId(joya.getId());
        joyaDto.setNombre(joya.getNombre());
        joyaDto.setMaterial(joya.getMaterial());
        joyaDto.setParticularidad(joya.getParticularidad());
        joyaDto.setPeso(joya.getPeso());
        joyaDto.setPosee_piedra(joya.getPosee_piedra());
        joyaDto.setVentaONo(joya.getVentaONo());
        return joyaDto;
    }
}
