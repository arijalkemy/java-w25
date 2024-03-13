package com.example.elasticDemo.services;

import com.example.elasticDemo.dto.ClothesDTO;
import com.example.elasticDemo.dto.ResponseDTO;
import com.example.elasticDemo.dto.SaleDTO;

import java.time.LocalDate;
import java.util.List;


public interface ISaleService {
    SaleDTO create(SaleDTO clothesDTO);

    SaleDTO update(SaleDTO clothesDTO);

    ResponseDTO delete(Long id);

    List<SaleDTO> findAll();

    SaleDTO findById(Long id);

    List<SaleDTO> findAllByFecha(LocalDate fecha);

    List<ClothesDTO> findClothesBySale(Long id);
}
