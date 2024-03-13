package com.implementacionbd.ejercicio.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.implementacionbd.ejercicio.model.Prenda;

public interface IPrendaRepository extends ElasticsearchRepository<Prenda, String> {
}
