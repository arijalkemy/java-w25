package com.implementacionbasedatos.ejercicio1.service;

import java.util.List;

import com.implementacionbasedatos.ejercicio1.dto.req.JewerlyReqDto;
import com.implementacionbasedatos.ejercicio1.dto.res.JewerlyResDto;
import com.implementacionbasedatos.ejercicio1.dto.res.MessageResDto;

public interface IJewerlyService {

    public List<JewerlyResDto> getJewerly();

    public MessageResDto postJewerly(JewerlyReqDto jewerlyDto);

    public MessageResDto deleteJewerly(long id);

    public JewerlyResDto getJewerlyById(long id);

    public JewerlyResDto putJewerly(Long id, JewerlyReqDto jewerlyDto);

}
