package com.calorias.SpringInyeccion.service;

import com.calorias.SpringInyeccion.DTO.ComidaDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IComidaService {

    ComidaDTO obtenerIngredientes(List<String> platos);
}
