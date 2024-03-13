package com.example.elasticDemo.services;

import com.example.elasticDemo.dto.ClothesDTO;
import com.example.elasticDemo.dto.ResponseDTO;
import com.example.elasticDemo.dto.SaleDTO;

import java.time.LocalDate;
import java.util.List;


public interface ISaleService {
    SaleDTO create(SaleDTO clothesDTO);

    SaleDTO update(SaleDTO clothesDTO);

    ResponseDTO delete(String id);

    List<SaleDTO> findAll();

    SaleDTO findById(String id);

    List<SaleDTO> findAllByFecha(LocalDate fecha);

    SaleDTO findClothesBySale(String id);
}
