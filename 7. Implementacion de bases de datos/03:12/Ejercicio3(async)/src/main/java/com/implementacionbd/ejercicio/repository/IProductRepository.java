package com.implementacionbd.ejercicio.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.implementacionbd.ejercicio.model.Product;

public interface IProductRepository extends ElasticsearchRepository<Product, String> {
}
