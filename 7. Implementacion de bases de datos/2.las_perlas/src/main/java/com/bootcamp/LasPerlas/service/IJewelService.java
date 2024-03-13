package com.bootcamp.LasPerlas.service;

import com.bootcamp.LasPerlas.dto.JewelRequestDTO;
import com.bootcamp.LasPerlas.dto.JewelResponseDTO;

import java.util.List;

public interface IJewelService {

    JewelResponseDTO createJewel(JewelRequestDTO jewelRequestDTO);
    List<JewelResponseDTO> getAllJewelry();
    void deleteJewel(Long id) throws Exception;
    void updateJewel(Long id, JewelRequestDTO jewelRequestDTO);
}
