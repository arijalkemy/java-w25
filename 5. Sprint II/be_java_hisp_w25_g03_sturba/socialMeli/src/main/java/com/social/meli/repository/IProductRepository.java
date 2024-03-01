package com.social.meli.repository;

import com.social.meli.entity.Product;

import java.util.Optional;

public interface IProductRepository {
    public void add(Product product);

    Optional<Product> getProductById(Integer productId);
}
