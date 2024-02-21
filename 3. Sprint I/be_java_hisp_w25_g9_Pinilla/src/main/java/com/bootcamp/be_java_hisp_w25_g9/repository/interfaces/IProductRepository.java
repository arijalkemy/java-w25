package com.bootcamp.be_java_hisp_w25_g9.repository.interfaces;

import com.bootcamp.be_java_hisp_w25_g9.model.Product;

import java.util.List;

public interface IProductRepository {

    void addProduct(Product product);

    List<Product> findAll();

    Product getProductById(int id);
}
