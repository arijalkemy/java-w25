package com.example.bootcamp.services;

import com.example.bootcamp.dto.CartDTO;
import com.example.bootcamp.repositories.ICartRepository;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ICartServices {
    List<CartDTO> findAll();
    CartDTO create(CartDTO cartNuevo);
    void delete(Long id);
}
