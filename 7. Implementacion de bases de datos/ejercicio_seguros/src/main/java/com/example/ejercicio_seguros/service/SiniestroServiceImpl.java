package com.example.ejercicio_seguros.service;

import com.example.ejercicio_seguros.dto.MensajeDTO;
import com.example.ejercicio_seguros.dto.SiniestroDTO;
import com.example.ejercicio_seguros.model.Siniestro;
import com.example.ejercicio_seguros.repository.ISiniestroRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.NamingConventions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiniestroServiceImpl implements ISiniestroService{

    ISiniestroRepository siniestroRepository;

    ModelMapper mapper = new ModelMapper();

    public SiniestroServiceImpl(ISiniestroRepository siniestroRepository) {
        this.siniestroRepository = siniestroRepository;
        this.mapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setSourceNamingConvention(NamingConventions.JAVABEANS_MUTATOR);
    }

    @Override
    public List<SiniestroDTO> listSiniestros() {
        List<Siniestro> siniestros = this.siniestroRepository.findAll();
        return siniestros.stream().map(siniestro -> mapper.map(siniestro, SiniestroDTO.class)).toList();
    }

    @Override
    public MensajeDTO guardarSinisetro(SiniestroDTO siniestroDTO) {
        Siniestro siniestro = mapper.map(siniestroDTO, Siniestro.class);
        this.siniestroRepository.save(siniestro);
        return new MensajeDTO("Siniestro guardado con exito");
    }
}
