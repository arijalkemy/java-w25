package org.example.seguros.service.impl;

import org.example.seguros.repository.ISiniestroRepository;
import org.example.seguros.service.ISiniestroService;
import org.springframework.stereotype.Service;

@Service
public class SiniestroService implements ISiniestroService {

    private final ISiniestroRepository siniestroRepository;

    public SiniestroService(ISiniestroRepository siniestroRepository){
        this.siniestroRepository = siniestroRepository;
    }


}
