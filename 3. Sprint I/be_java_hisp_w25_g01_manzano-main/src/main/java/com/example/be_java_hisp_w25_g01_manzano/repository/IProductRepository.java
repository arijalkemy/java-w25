package com.example.be_java_hisp_w25_g01_manzano.repository;

import com.example.be_java_hisp_w25_g01_manzano.entity.Product;

import java.util.List;
import java.util.Optional;
public interface IProductRepository{
        public List<Product> getAll();
        public Optional<Product> findById(Integer id);
}
