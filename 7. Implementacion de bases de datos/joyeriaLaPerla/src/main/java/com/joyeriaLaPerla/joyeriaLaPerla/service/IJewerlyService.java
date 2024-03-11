package com.joyeriaLaPerla.joyeriaLaPerla.service;

import com.joyeriaLaPerla.joyeriaLaPerla.dto.JewerlyDTO;
import com.joyeriaLaPerla.joyeriaLaPerla.dto.MessageDTO;
import com.joyeriaLaPerla.joyeriaLaPerla.model.Jewerly;

import java.util.List;

public interface IJewerlyService {
    public MessageDTO saveJewerly(JewerlyDTO jewerly);
    public MessageDTO deleteJewerly(Long id);
    public MessageDTO editJewerly(Long id, JewerlyDTO jewerly);
    public List<Jewerly> getAllJewerly();
}
