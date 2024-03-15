package com.example.showroom.service;

import com.example.showroom.dto.request.ClotheReqDto;
import com.example.showroom.dto.response.ClotheDto;
import com.example.showroom.dto.response.ConfirmationMessage;
import com.example.showroom.dto.response.ErrorMessage;
import com.example.showroom.model.Clothe;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.showroom.repository.ClotheRepository;
import java.util.List;

@Service
public class ClothesServiceImpl implements IClothesService{

    private final ClotheRepository clotheRepository;
    private final ModelMapper mapper;

    public ClothesServiceImpl(ClotheRepository clotheRepository, ModelMapper mapper){
        this.clotheRepository = clotheRepository;
        this.mapper = mapper;
    }

    @Override
    public ConfirmationMessage saveNewClothes(ClotheReqDto clothesDTO) {
        Clothe savedClothe = clotheRepository.save(mapper.map(clothesDTO, Clothe.class));
        return new ConfirmationMessage("La prenda fue guardada exitosamente con codigo: " + savedClothe.getCodigo() + ".");
    }

    @Override
    public List<ClotheDto> getAllClothes() {
        List<Clothe> listClothe = clotheRepository.findAll();
        return listClothe.stream().map(c->mapper.map(c, ClotheDto.class)).toList();
    }

    @Override
    public ClotheDto getClotheByCode(Long code) {
        return mapper.map(clotheRepository.findById(code), ClotheDto.class);
    }

    @Override
    public ConfirmationMessage updateClothe(ClotheReqDto clotheDto, Long code) {
        Clothe existingClothe = clotheRepository.findById(code).orElseThrow();
        Clothe newClothe = mapper.map(clotheDto, Clothe.class);
        newClothe.setCodigo(existingClothe.getCodigo());
        return new ConfirmationMessage("La prenda con codigo: " + clotheRepository.save(newClothe).getCodigo() + " fue actualizada exitosamente.");
    }

    @Override
    public ConfirmationMessage deleteClothesById(Long code) {
        clotheRepository.deleteById(code);
        return new ConfirmationMessage("La prenda codigo: "+ code +" fue eliminada correctamente.");
    }

    @Override
    public List<ClotheDto> getClothesBySize(String size) {
        return this.clotheRepository.findClothesByTalleIgnoreCase(size).stream()
                .map(clothe -> mapper.map(clothe, ClotheDto.class))
                .toList();
    }

    @Override
    public List<ClotheDto> getClothesByName(String name) {
        return clotheRepository.findClothesByNombreContainingIgnoreCase(name).stream()
                .map(clothe -> mapper.map(clothe, ClotheDto.class))
                .toList();
    }
}
