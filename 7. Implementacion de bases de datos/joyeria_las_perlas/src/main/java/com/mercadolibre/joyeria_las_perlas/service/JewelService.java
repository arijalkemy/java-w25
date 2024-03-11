package com.mercadolibre.joyeria_las_perlas.service;

import com.mercadolibre.joyeria_las_perlas.dto.JewelGetResponse;
import com.mercadolibre.joyeria_las_perlas.dto.JewelPostRequest;
import com.mercadolibre.joyeria_las_perlas.dto.JewelPostResponse;
import com.mercadolibre.joyeria_las_perlas.model.Jewel;
import com.mercadolibre.joyeria_las_perlas.repository.JewelRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JewelService implements IJewelService {
    private final ModelMapper modelMapper;
    private final JewelRepository jewelRepository;
    @Override
    public JewelPostResponse createJewel(JewelPostRequest jewelPostRequest){
        Jewel jewelToCreate = modelMapper.map(jewelPostRequest, Jewel.class);
        return modelMapper.map(jewelRepository.save(jewelToCreate), JewelPostResponse.class);
    }
    @Override
    public List<JewelGetResponse> getAllRegisteredJewels() {
        return jewelRepository.findByIsOnSaleTrue()
                .stream().map(jewel -> modelMapper.map(jewel, JewelGetResponse.class))
                .toList();
    }

    @Override
    public JewelGetResponse deleteJewel(Long id){
        Jewel existingJewel = jewelRepository.findById(id).orElseThrow();
        existingJewel.setIsOnSale(false);
        return modelMapper.map(jewelRepository.save(existingJewel), JewelGetResponse.class);
    }
    @Override
    public JewelGetResponse updateJewel(Long id, JewelPostRequest newJewelRequest){
        Jewel jewelToUpdate = jewelRepository.findById(id).orElseThrow();
        Jewel newJewel = modelMapper.map(newJewelRequest, Jewel.class);
        newJewel.setId(jewelToUpdate.getId());
        return modelMapper.map(jewelRepository.save(newJewel), JewelGetResponse.class);
    }
}
