package com.breakingbytes.be_java_hisp_w25_g04_gutierrez.repository;

import com.breakingbytes.be_java_hisp_w25_g04_gutierrez.entity.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
}
