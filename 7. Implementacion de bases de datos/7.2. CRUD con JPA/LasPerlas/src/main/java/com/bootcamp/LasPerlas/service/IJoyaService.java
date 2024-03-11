package com.bootcamp.LasPerlas.service;

import com.bootcamp.LasPerlas.dto.MessageDTO;
import com.bootcamp.LasPerlas.model.Joya;

import java.util.List;

public interface IJoyaService {

    MessageDTO saveJoya(Joya joya);
    List<Joya> getJoyas();
    Joya findJoya(Long id);
    MessageDTO deleteJoya(Long id);
    MessageDTO editJoya(Long id_modificar, Joya joya_modif);

}
