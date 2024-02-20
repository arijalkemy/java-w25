package com.breakingbytes.be_java_hisp_w25_g04_gutierrez.repository;

import com.breakingbytes.be_java_hisp_w25_g04_gutierrez.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ProductRepositoryImpl implements IProductRepository{
    @Override
    public List<Product> findAll() {
        return DbMock.getInstance().getListOfProduct();
    }
}
