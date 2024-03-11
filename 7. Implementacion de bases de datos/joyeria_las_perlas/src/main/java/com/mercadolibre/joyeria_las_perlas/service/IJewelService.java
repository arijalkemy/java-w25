package com.mercadolibre.joyeria_las_perlas.service;

import com.mercadolibre.joyeria_las_perlas.dto.JewelGetResponse;
import com.mercadolibre.joyeria_las_perlas.dto.JewelPostRequest;
import com.mercadolibre.joyeria_las_perlas.dto.JewelPostResponse;
import com.mercadolibre.joyeria_las_perlas.model.Jewel;

import java.util.List;

public interface IJewelService {
    JewelPostResponse createJewel(JewelPostRequest jewelPostRequest);

    List<JewelGetResponse> getAllRegisteredJewels();

    JewelGetResponse deleteJewel(Long id);

    JewelGetResponse updateJewel(Long id, JewelPostRequest newJewelRequest);
}
