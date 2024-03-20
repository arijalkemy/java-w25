package com.example.ejercicio_seguros.service;

import com.example.ejercicio_seguros.dto.MensajeDTO;
import com.example.ejercicio_seguros.dto.SiniestroDTO;

import java.util.List;

public interface ISiniestroService {
    List<SiniestroDTO> listSiniestros();
    MensajeDTO guardarSinisetro(SiniestroDTO siniestroDTO);
}
