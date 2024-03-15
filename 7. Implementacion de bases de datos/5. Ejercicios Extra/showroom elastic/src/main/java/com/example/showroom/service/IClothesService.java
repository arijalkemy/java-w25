package com.example.showroom.service;

import com.example.showroom.dto.request.ClotheReqDto;
import com.example.showroom.dto.response.ClotheDto;
import com.example.showroom.dto.response.ConfirmationMessage;

import java.util.List;

public interface IClothesService {
    ConfirmationMessage saveNewClothes(ClotheReqDto clothesDTO);

    List<ClotheDto> getAllClothes();

    ClotheDto getClotheByCode(String code);

    ConfirmationMessage updateClothe(ClotheReqDto clotheDto, String code);

    ConfirmationMessage deleteClothesById(String code);

    List<ClotheDto> getClothesBySize(String size);

    List<ClotheDto> getClothesByName(String name);
}
