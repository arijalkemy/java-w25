package com.example.ejemplo_jpa.service;

import com.example.ejemplo_jpa.dto.request.JewelDTO;
import com.example.ejemplo_jpa.model.Jewel;
import java.util.List;

public interface IJewelryService {

    public List<JewelDTO> getJewels();
    public void saveJewel(JewelDTO stu);
    public void deleteJewel(long id);
    public JewelDTO findJewel(long id);



}
