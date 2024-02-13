package com.example.calorias.service;

import com.example.calorias.dto.FoodDto;
import com.example.calorias.repository.FoodRepositoryImp;

import org.springframework.stereotype.Service;
import com.example.calorias.entity.Food;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {
    FoodRepositoryImp repository = new FoodRepositoryImp();

    public List<Food> getAll() {
        return repository.findAll();
    }
}
