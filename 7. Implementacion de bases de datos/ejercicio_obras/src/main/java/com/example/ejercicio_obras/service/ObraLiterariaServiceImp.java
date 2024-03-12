package com.example.ejercicio_obras.service;


import com.example.ejercicio_obras.dto.ObraLiterariaDTO;
import com.example.ejercicio_obras.model.ObraLiteraria;
import com.example.ejercicio_obras.repository.IObrasRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObraLiterariaServiceImp implements IObraLiterariaService {
    @Autowired
    IObrasRepository obraRepository;

    @Override
    public ObraLiterariaDTO save(ObraLiterariaDTO obraLiterariaDTO) {
        ModelMapper mapper = new ModelMapper();
        ObraLiteraria obraLiteraria = mapper.map(obraLiterariaDTO, ObraLiteraria.class);

        return mapper.map(obraRepository.save(obraLiteraria), ObraLiterariaDTO.class);
    }

    // 1
    @Override
    public List<ObraLiterariaDTO> getBookByAutor(String name) {
        ModelMapper mapper = new ModelMapper();
        return obraRepository.getAllByAutor(name)
                .stream().map(obraLiteraria -> mapper.map(obraLiteraria, ObraLiterariaDTO.class)).toList();
    }

    // 2
    @Override
    public List<ObraLiterariaDTO> listByKeyWords(String keyWord) {
        ModelMapper mapper = new ModelMapper();
        return obraRepository.findByNombreContaining(keyWord)
              .stream().map(obra -> mapper.map(obra, ObraLiterariaDTO.class)).toList();
    }

    // 3
    @Override
    public List<ObraLiterariaDTO> listTopFive() {
        ModelMapper mapper = new ModelMapper();

        return obraRepository.findTop5ByOrderByPaginasDesc()
                .stream().map(obra -> mapper.map(obra, ObraLiterariaDTO.class)).toList();
    }

    // 4
    @Override
    public List<ObraLiterariaDTO> listBefore(Integer anio) {
        ModelMapper mapper = new ModelMapper();

        return obraRepository.findAllByAnio(anio)
                .stream().map(obra -> mapper.map(obra, ObraLiterariaDTO.class)).toList();
    }

    @Override
    public List<ObraLiteraria> listByEditorial(String editorial) {
        ModelMapper mapper = new ModelMapper();

        return null;
    }
}
