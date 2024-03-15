package com.consultashql.service;

import com.consultashql.DTO.SiniestroDTO;
import com.consultashql.model.Siniestro;

import java.util.List;

public interface ISiniestroService {


    SiniestroDTO addNewSiniestro(SiniestroDTO siniestroDTO);
    List<SiniestroDTO> getAllSiniestros();
}
