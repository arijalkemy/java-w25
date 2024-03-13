package com.bootcamp.LasPerlas.service;

import com.bootcamp.LasPerlas.dto.JewelRequestDTO;
import com.bootcamp.LasPerlas.dto.JewelResponseDTO;
import com.bootcamp.LasPerlas.model.Jewel;
import com.bootcamp.LasPerlas.repository.IJewelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JewelService implements IJewelService {

    private final IJewelRepository jewelRepo;
    private final ModelMapper modelMapper;

    public JewelService(IJewelRepository jewelRepo) {
        this.jewelRepo = jewelRepo;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public JewelResponseDTO createJewel(JewelRequestDTO jewelRequestDTO) {
        Jewel jewel = modelMapper.map(jewelRequestDTO, Jewel.class);
        jewel.setSaleOrNot(true);
        Jewel jewelResponse  = jewelRepo.save(jewel);
        return modelMapper.map(jewelResponse, JewelResponseDTO.class);
    }

    @Override
    public List<JewelResponseDTO> getAllJewelry() {
        List<JewelResponseDTO> jewelListDTO =
                jewelRepo.findAll().stream()
                        .filter( j -> j.isSaleOrNot() == true)
                        .map( jewel -> modelMapper.map(jewel, JewelResponseDTO.class))
                        .collect(Collectors.toList());
        return jewelListDTO;
    }

    @Override
    public void deleteJewel(Long id) {
        Jewel jewel = jewelRepo.findById(id).orElse(null);
        if( jewel == null || jewel.isSaleOrNot() == false)
            throw new RuntimeException("No se encontro la Joya");
        jewel.setSaleOrNot(false);
        jewelRepo.save(jewel);
    }

    @Override
    public void updateJewel(Long id, JewelRequestDTO jewelRequestDTO) {
        Jewel jewel = jewelRepo.findById(id).orElse(null);
        if( jewel == null || jewel.isSaleOrNot() == false)
            throw new RuntimeException("No se encontro la Joya");
        jewel.setName(jewelRequestDTO.getName());
        jewel.setMaterial(jewelRequestDTO.getMaterial());
        jewel.setWeight(jewelRequestDTO.getWeight());
        jewel.setParticularity(jewelRequestDTO.getParticularity());
        jewel.setHasStone(jewelRequestDTO.isHasStone());

        jewelRepo.save(jewel);
    }
}
