package com.example.showroom.service;

import com.example.showroom.dto.request.ClotheReqDto;
import com.example.showroom.dto.response.ClotheDto;
import com.example.showroom.dto.response.ConfirmationMessage;

import java.util.List;

public interface IClothesService {
    ConfirmationMessage saveNewClothes(ClotheReqDto clothesDTO);

    List<ClotheDto> getAllClothes();

    ClotheDto getClotheByCode(Long code);

    ConfirmationMessage updateClothe(ClotheReqDto clotheDto, Long code);

    ConfirmationMessage deleteClothesById(Long code);

    List<ClotheDto> getClothesBySize(String size);

    List<ClotheDto> getClothesByName(String name);
}
