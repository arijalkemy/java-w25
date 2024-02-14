package com.bootcamp.Calorias.service;

import com.bootcamp.Calorias.dto.request.RequestCaloriasDTO;
import com.bootcamp.Calorias.dto.response.ResponseCaloriasDTO;

import java.util.List;

public interface ICaloriasService {
        ResponseCaloriasDTO getCalorias(RequestCaloriasDTO nombre);
        List<ResponseCaloriasDTO> getCaloriasVarias(List<RequestCaloriasDTO> platos);
    }
