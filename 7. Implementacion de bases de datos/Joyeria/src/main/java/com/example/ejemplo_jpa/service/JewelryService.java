package com.example.ejemplo_jpa.service;

import com.example.ejemplo_jpa.dto.request.JewelDTO;
import com.example.ejemplo_jpa.model.Jewel;
import com.example.ejemplo_jpa.repository.JewelRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class JewelryService implements IJewelryService {

    private ObjectMapper mapper =
            new ObjectMapper()
                    /*.configure(
                    DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)*/;

private final JewelRepository jewelRepo;

 //Si implemento con constructor es así:
    public JewelryService(JewelRepository jewelRepo) {
        this.jewelRepo = jewelRepo;
    }

    @Override
    @Transactional (readOnly = true)
    public List<JewelDTO> getJewels() {
        List<Jewel> jewelList = jewelRepo.findAll();
        return mapper.convertValue(
                jewelList,
                new TypeReference<>() {}
        );
    }

    @Override
    @Transactional
    public void saveJewel(JewelDTO jewelDTO) {
        /*Jewel jewel =
                new Jewel(
                        jewelDTO.getNombre(),
                        jewelDTO.getMaterial(),
                        jewelDTO.getPeso(),
                        jewelDTO.getParticularidad(),
                        jewelDTO.getPoseePiedra(),
                        jewelDTO.getVentaONo()
                );*/
        jewelRepo.save(mapper.convertValue(jewelDTO, Jewel.class));
    }

    @Override
    @Transactional
    public void deleteJewel(long id) {
        jewelRepo.deleteById(id);
    }

    //el método edit no existe más

    @Override
    @Transactional (readOnly = true)
    public JewelDTO findJewel(long id) {
        //acá si no encuentro el jeweldent, devuelvo null, eso hace el orElse
        Jewel jewel = jewelRepo.findById(id).orElse(null);
        return mapper.convertValue(jewel, JewelDTO.class);
    }


}



