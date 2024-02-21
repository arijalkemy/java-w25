package com.social.meli.repository;

import com.social.meli.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements IProductRepository{
    List<Product> productList;

    public ProductRepository() {
        this.productList = new ArrayList<>();
    }


    @Override
    public void add(Product product) {
        this.productList.add(product);
    }

    @Override
    public Optional<Product> getProductById(Integer productId) {
        return productList.stream().filter(p -> p.getId().equals(productId)).findFirst();
    }
}
