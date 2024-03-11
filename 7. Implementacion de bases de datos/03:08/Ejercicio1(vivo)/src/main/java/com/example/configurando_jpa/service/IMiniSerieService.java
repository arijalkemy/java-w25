package com.example.configurando_jpa.service;

import java.util.List;

import com.example.configurando_jpa.dto.MiniSerieDto;
import com.example.configurando_jpa.dto.res.MessageDto;
import com.example.configurando_jpa.model.MiniSerie;

public interface IMiniSerieService {

    public List<MiniSerie> getMiniSeries();

    public MessageDto saveMiniSerie(MiniSerieDto miniSerieDto);

    public MessageDto deleteMiniSerie(long id);

    public MiniSerieDto findMiniSerie(long id);

}
