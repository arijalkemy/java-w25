package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.repository;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IProductRepository {
    void addProduct(Product product);
    List<Product> getAll();
    Optional<Product> getProductById(Integer id);
}
