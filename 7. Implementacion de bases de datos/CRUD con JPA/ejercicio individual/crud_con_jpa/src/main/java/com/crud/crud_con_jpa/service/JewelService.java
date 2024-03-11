package com.crud.crud_con_jpa.service;

import com.crud.crud_con_jpa.dto.JewelDTO;
import com.crud.crud_con_jpa.models.Jewel;
import com.crud.crud_con_jpa.repository.JewelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface JewelService {
    public List<Jewel> getAllJewels();
    public void saveJewel(Jewel newJewel);
    public void deleteJewel(Long id);
    public void modifyJewel(Long id_modificar, Jewel jewelMod);

    public Optional<Jewel> getJewelById(Long id);
}
