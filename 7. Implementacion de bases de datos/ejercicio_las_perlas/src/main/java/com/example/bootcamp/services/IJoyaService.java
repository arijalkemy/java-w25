package com.example.bootcamp.services;

import com.example.bootcamp.dto.JoyaDTO;
import com.example.bootcamp.model.Joya;

import java.util.List;

public interface IJoyaService {
    public Joya create(JoyaDTO joya);
    public List<Joya> getAll();
    public void delete(String id);
    public Joya update(JoyaDTO joyaDTO);
}
