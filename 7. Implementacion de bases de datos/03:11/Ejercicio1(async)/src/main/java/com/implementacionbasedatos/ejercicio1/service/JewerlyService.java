package com.implementacionbasedatos.ejercicio1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.implementacionbasedatos.ejercicio1.dto.req.JewerlyReqDto;
import com.implementacionbasedatos.ejercicio1.dto.res.JewerlyResDto;
import com.implementacionbasedatos.ejercicio1.dto.res.MessageResDto;
import com.implementacionbasedatos.ejercicio1.exception.NotFoundException;
import com.implementacionbasedatos.ejercicio1.model.Jewerly;
import com.implementacionbasedatos.ejercicio1.repository.IJewerlyRepository;

@Service
public class JewerlyService implements IJewerlyService {
    private final IJewerlyRepository iJewerlyRepository;

    public JewerlyService(IJewerlyRepository iJewerlyRepository) {
        this.iJewerlyRepository = iJewerlyRepository;
    }

    private Jewerly jewerlyReqDtoToModel(JewerlyReqDto jewerlyDto) {
        return new Jewerly(jewerlyDto.getNroIdentificatorio(), jewerlyDto.getNombre(), jewerlyDto.getMaterial(),
                jewerlyDto.getPesoGramos(), jewerlyDto.getParticularidad(), jewerlyDto.getPoseePiedra(),
                jewerlyDto.getVentaONo());
    }

    private JewerlyReqDto jewerlyResDtoToReqDto(JewerlyResDto jewerlyDto) {
        return new JewerlyReqDto(jewerlyDto.getNroIdentificatorio(), jewerlyDto.getNombre(), jewerlyDto.getMaterial(),
                jewerlyDto.getPesoGramos(), jewerlyDto.getParticularidad(), jewerlyDto.getPoseePiedra(),
                jewerlyDto.getVentaONo());
    }

    private JewerlyResDto jewerlyModelToResDto(Jewerly jewerly) {
        return new JewerlyResDto(jewerly.getNroIdentificatorio(), jewerly.getNombre(), jewerly.getMaterial(),
                jewerly.getPesoGramos(), jewerly.getParticularidad(), jewerly.getPoseePiedra(),
                jewerly.getVentaONo());
    }

    @Override
    @Transactional(readOnly = true)
    public List<JewerlyResDto> getJewerly() {
        List<Jewerly> jewerlyList = iJewerlyRepository.findAll();
        List<JewerlyResDto> jewerlyListDto = new ArrayList<>();
        for (Jewerly e : jewerlyList) {
            jewerlyListDto.add(jewerlyModelToResDto(e));
        }
        return jewerlyListDto;
    }

    @Override
    @Transactional(readOnly = true)
    public JewerlyResDto getJewerlyById(long id) {
        Jewerly jewerly = iJewerlyRepository.findById(id).orElse(null);
        if (jewerly == null) {
            throw new NotFoundException("No se encontró ninguna joya con el id indicado.");
        }
        return jewerlyModelToResDto(jewerly);
    }

    @Override
    @Transactional
    public MessageResDto postJewerly(JewerlyReqDto miniSerieDto) {
        iJewerlyRepository.save(jewerlyReqDtoToModel(miniSerieDto));
        return new MessageResDto("La joya fue agregada correctamente");
    }

    @Override
    @Transactional
    public MessageResDto deleteJewerly(long id) {
        Jewerly miniSerie = iJewerlyRepository.findById(id).orElse(null);
        if (miniSerie == null) {
            throw new NotFoundException("No se encontró ninguna joya con el id indicado.");
        }
        iJewerlyRepository.deleteById(id);
        return new MessageResDto("La joya fue borrada correctamente");
    }

    @Override
    @Transactional
    public JewerlyResDto putJewerly(Long id, JewerlyReqDto jewerlyDto) {
        JewerlyResDto jewerlyFound = this.getJewerlyById(id);
        jewerlyFound.setNombre(jewerlyDto.getNombre());
        jewerlyFound.setMaterial(jewerlyDto.getMaterial());
        jewerlyFound.setParticularidad(jewerlyDto.getParticularidad());
        jewerlyFound.setPesoGramos(jewerlyDto.getPesoGramos());
        jewerlyFound.setPoseePiedra(jewerlyDto.getPoseePiedra());
        jewerlyFound.setVentaONo(jewerlyDto.getVentaONo());
        this.postJewerly(jewerlyResDtoToReqDto(jewerlyFound));
        return jewerlyFound;
    }

}
