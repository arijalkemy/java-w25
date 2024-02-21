package com.mercadolibre.be_java_hisp_w25_g15.repository.impl;

import com.mercadolibre.be_java_hisp_w25_g15.model.Product;
import com.mercadolibre.be_java_hisp_w25_g15.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductRepository implements IProductRepository {
    List<Product> products = new ArrayList<>();
    @Override
    public Product save(Product product) {
        this.products.add(product);
        return product;
    }
}
