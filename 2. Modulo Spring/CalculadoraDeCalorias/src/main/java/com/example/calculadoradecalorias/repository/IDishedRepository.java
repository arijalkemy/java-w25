package com.example.calculadoradecalorias.repository;

import com.example.calculadoradecalorias.entity.Ingrediente;
import com.example.calculadoradecalorias.entity.Plato;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDishedRepository {
    List<Plato> getDishes();

}
