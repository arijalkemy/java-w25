package com.example.SegurosDeAutos.service;

import com.example.SegurosDeAutos.dto.RequestSiniestroDTO;
import com.example.SegurosDeAutos.dto.SiniestroDTO;
import java.util.List;
public interface ISiniestroServices {

    SiniestroDTO addSiniestro(RequestSiniestroDTO siniestroDTO);
    SiniestroDTO getSiniestroById(Long id);
    List<SiniestroDTO> getSiniestros();

}
