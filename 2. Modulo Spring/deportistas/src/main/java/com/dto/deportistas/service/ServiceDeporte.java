package com.dto.deportistas.service;

import com.dto.deportistas.model.Deporte;
import com.dto.deportistas.repository.DeporteRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceDeporte {

    @Autowired
    DeporteRepositoryImp deporteRepositoryImp;

    public List<Deporte> getDeportes(){
        return deporteRepositoryImp.getLista();
    }

    public List<Deporte> findByName(String name){
        return deporteRepositoryImp.findByName(name);
    }
}
