package com.example.elasticDemo.services;

import com.example.elasticDemo.dto.ClothesDTO;
import com.example.elasticDemo.dto.ResponseDTO;
import com.example.elasticDemo.model.Clothes;

import java.util.List;
import java.util.Optional;

public interface IClothesService {
    ClothesDTO create(ClothesDTO clothesDTO);

    ClothesDTO update(ClothesDTO clothesDTO);

    ResponseDTO delete(String id);

    List<ClothesDTO> findAll();

    ClothesDTO findById(String id);

    List<ClothesDTO> findAllByTalle(Double talle);

    List<ClothesDTO> findAllByNameRegex(String clave);
}
