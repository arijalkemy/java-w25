package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.repository;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryImpl implements IProductRepository{
    List<Product> products=new ArrayList<>();

    @Override
    public void addProduct(Product product) {
        products.add(product);

    }

    @Override
    public List<Product> getAll() {
        return this.products;
    }

    @Override
    public Optional<Product> getProductById(Integer id) {
        return products.stream().filter(product -> product.getProduct_id().equals(id)).findFirst();
    }
}
