package com.example.be_java_hisp_w25_g01.repository;

import com.example.be_java_hisp_w25_g01.entity.Product;

import java.util.List;
import java.util.Optional;
public interface IProductRepository{
        public List<Product> getAll();
        public Optional<Product> findById(Integer id);
}
