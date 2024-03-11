package com.miniseries.miniseries.service;

import com.miniseries.miniseries.DTO.MiniserieDTO;
import com.miniseries.miniseries.model.Miniserie;
import com.miniseries.miniseries.repository.IMiniserieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MiniserieService {
    @Autowired
    IMiniserieRepository miniserieRepository;

    public String agregarminiserie(MiniserieDTO miniserieDTO){
        Miniserie miniserie=new Miniserie(
                miniserieDTO.id(),
                miniserieDTO.name(),
                miniserieDTO.rating(),
                miniserieDTO.amountOfAwards()
        );

        miniserieRepository.save(miniserie);

        return "Miniserie Added";
    }
}
