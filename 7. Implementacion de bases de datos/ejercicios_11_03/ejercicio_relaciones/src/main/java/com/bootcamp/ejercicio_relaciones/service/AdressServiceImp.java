package com.bootcamp.ejercicio_relaciones.service;

import com.bootcamp.ejercicio_relaciones.dto.AdressDTO;
import com.bootcamp.ejercicio_relaciones.dto.ResponseDTO;
import com.bootcamp.ejercicio_relaciones.model.Adress;
import com.bootcamp.ejercicio_relaciones.repository.IAdressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdressServiceImp implements IAdressService {
    private final IAdressRepository adressRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public AdressServiceImp(IAdressRepository adressRepository) {
        this.adressRepository = adressRepository;
    }

    @Override
    public ResponseDTO save(AdressDTO adressDTO) {
        //Verificamos que la dirección no exista, si no existe la creamos
        Optional<Adress> adress = adressRepository
                .findByStreetAndNumberAndCity(adressDTO.getStreet(), adressDTO.getNumber(), adressDTO.getCity());
        if (adress.isPresent()) {
            return new ResponseDTO("Adress already exists");
        }
        Adress newAdress = modelMapper.map(adressDTO, Adress.class);
        adressRepository.save(newAdress);
        return new ResponseDTO("Adress saved successfully");
    }

    @Override
    public List<AdressDTO> getAll() {
        return adressRepository.findAll()
                .stream().map(adress -> modelMapper.map(adress, AdressDTO.class)).toList();
    }

    @Override
    public ResponseDTO delete(Long id) {
        adressRepository.deleteById(id);
        return new ResponseDTO("Adress deleted successfully");
    }
}
