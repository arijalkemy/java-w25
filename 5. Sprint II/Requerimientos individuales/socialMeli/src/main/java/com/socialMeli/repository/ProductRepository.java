package com.socialMeli.repository;

import com.socialMeli.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements IProductRepository{
    List<Product> productList = new ArrayList<>();

    public ProductRepository() {
        this.productList.add(new Product(1, "Silla Gamer", "Gamer",
                "Red", "Razer", "Premium"));
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
