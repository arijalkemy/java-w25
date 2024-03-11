package com.example.bootcamp.services;

import com.example.bootcamp.dto.JoyaDTO;
import com.example.bootcamp.model.Joya;
import com.example.bootcamp.repositories.IJoyaRepository;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;

@Service
public class JoyaService implements IJoyaService{
    private final IJoyaRepository joyaRepository;

    public JoyaService(IJoyaRepository joyaRepository){
        this.joyaRepository = joyaRepository;
    }

    @Override
    public Joya create(JoyaDTO joya){
        ModelMapper modelMapper = new ModelMapper();
        Joya j = modelMapper.map(joya, Joya.class);
        return joyaRepository.save(j);
    }

    @Override
    public List<Joya> getAll(){
        List<Joya> joyas =  joyaRepository.findAll();
        if(joyas.isEmpty()) throw new RuntimeException("No se encontraron joyas");
        return null;
    }

    @Override
    public void delete(String id){

    }

    @Override
    public Joya update(JoyaDTO joyaDTO){
        return null;
    }
}
