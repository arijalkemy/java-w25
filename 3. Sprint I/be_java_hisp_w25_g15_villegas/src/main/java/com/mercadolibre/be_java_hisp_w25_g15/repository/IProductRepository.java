package com.mercadolibre.be_java_hisp_w25_g15.repository;

import com.mercadolibre.be_java_hisp_w25_g15.model.Product;

public interface IProductRepository {
    Product save(Product product);
}
