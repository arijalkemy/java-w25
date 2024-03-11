package com.example.configurando_jpa.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.example.configurando_jpa.dto.MiniSerieDto;
import com.example.configurando_jpa.dto.res.MessageDto;
import com.example.configurando_jpa.exception.NotFoundException;
import com.example.configurando_jpa.model.MiniSerie;
import com.example.configurando_jpa.repository.IMiniSerieRepository;

@Service
public class MiniSerieService implements IMiniSerieService {
    private final IMiniSerieRepository miniSerieRepository;

    public MiniSerieService(IMiniSerieRepository miniSerieRepository) {
        this.miniSerieRepository = miniSerieRepository;
    }

    private MiniSerie miniSerieDtoToModel(MiniSerieDto miniSerieDto) {
        return new MiniSerie(miniSerieDto.getId(), miniSerieDto.getName(), miniSerieDto.getRating(),
                miniSerieDto.getAmountOfAwards());
    }

    private MiniSerieDto miniSerieToDto(MiniSerie miniSerie) {
        return new MiniSerieDto(miniSerie.getId(), miniSerie.getName(), miniSerie.getRating(),
                miniSerie.getAmountOfAwards());
    }

    @Override
    @Transactional(readOnly = true)
    public List<MiniSerie> getMiniSeries() {
        List<MiniSerie> miniSeriesList = miniSerieRepository.findAll();
        return miniSeriesList;
    }

    @Override
    @Transactional(readOnly = true)
    public MiniSerieDto findMiniSerie(long id) {
        MiniSerie miniSerie = miniSerieRepository.findById(id).orElse(null);
        if (miniSerie == null) {
            throw new NotFoundException("No se encontró ninguna miniserie con el id indicado.");
        }
        return miniSerieToDto(miniSerie);
    }

    @Override
    @Transactional
    public MessageDto saveMiniSerie(MiniSerieDto miniSerieDto) {
        miniSerieRepository.save(miniSerieDtoToModel(miniSerieDto));
        return new MessageDto("La miniserie fue agregada correctamente");
    }

    @Override
    @Transactional
    public MessageDto deleteMiniSerie(long id) {
        MiniSerie miniSerie = miniSerieRepository.findById(id).orElse(null);
        if (miniSerie == null) {
            throw new NotFoundException("No se encontró ninguna miniserie con el id indicado.");
        }
        miniSerieRepository.deleteById(id);
        return new MessageDto("La miniserie fue borrada correctamente");
    }

}
