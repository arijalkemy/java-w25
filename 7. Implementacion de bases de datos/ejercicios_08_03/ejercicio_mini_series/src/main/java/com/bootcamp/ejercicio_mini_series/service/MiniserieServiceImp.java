package com.bootcamp.ejercicio_mini_series.service;

import com.bootcamp.ejercicio_mini_series.dto.request.MiniserieRequestDTO;
import com.bootcamp.ejercicio_mini_series.dto.response.MiniserieResponseDTO;
import com.bootcamp.ejercicio_mini_series.model.MiniSerie;
import com.bootcamp.ejercicio_mini_series.repository.IMiniserieRepository;
import com.bootcamp.ejercicio_mini_series.util.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MiniserieServiceImp implements IMiniserieService {
    private final IMiniserieRepository miniserieRepository;

    public MiniserieServiceImp(IMiniserieRepository miniserieRepository) {
        this.miniserieRepository = miniserieRepository;
    }

    @Override
    public List<MiniserieResponseDTO> findAll() {
        List<MiniSerie> listOfMiniseries = miniserieRepository.findAll();
        return listOfMiniseries.stream().map(Mapper::getResponse).toList();
    }

    @Override
    public MiniserieResponseDTO findMiniserieById(Long id) {
        Optional<MiniSerie> miniserie = miniserieRepository.findById(id);
        if (miniserie.isEmpty())
            throw new RuntimeException("Miniserie not found");
        return Mapper.getResponse(miniserie.get());
    }

    @Override
    public void save(MiniserieRequestDTO miniserieRequestDTO) {
        miniserieRepository.save(Mapper.getEntity(miniserieRequestDTO));
    }

    @Override
    public MiniserieResponseDTO getByName(String name) {
        Optional<MiniSerie> miniserie = miniserieRepository.getByName(name);
        if (miniserie.isEmpty())
            throw new RuntimeException("Miniserie not found");
        return Mapper.getResponse(miniserie.get());
    }

    @Override
    public void deleteById(Long id) {
        miniserieRepository.deleteById(id);
    }
}
