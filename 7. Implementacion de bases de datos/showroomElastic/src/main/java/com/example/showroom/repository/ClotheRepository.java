package com.example.showroom.repository;

import com.example.showroom.model.Clothe;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface  ClotheRepository extends ElasticsearchRepository<Clothe, String> {

    List<Clothe> findAll();
    List<Clothe> findClothesByNombreContainingIgnoreCase(String nombre);
    List<Clothe> findClothesByTalleIgnoreCase(String talle);
}