package com.socialMeli.repository;

import com.socialMeli.entity.Product;

import java.util.Optional;

public interface IProductRepository {
    public void add(Product product);

    Optional<Product> getProductById(Integer productId);
}
