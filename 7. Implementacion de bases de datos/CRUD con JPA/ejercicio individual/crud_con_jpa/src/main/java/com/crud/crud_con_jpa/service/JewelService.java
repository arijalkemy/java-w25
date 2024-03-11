package com.crud.crud_con_jpa.service;

import com.crud.crud_con_jpa.dto.JewelDTO;
import com.crud.crud_con_jpa.models.Jewel;
import com.crud.crud_con_jpa.repository.JewelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JewelService {
    public List<Jewel> getAllJewels();
    public void saveJewel(Jewel newJewel);
    public void deleteJewel(Long id);
}
