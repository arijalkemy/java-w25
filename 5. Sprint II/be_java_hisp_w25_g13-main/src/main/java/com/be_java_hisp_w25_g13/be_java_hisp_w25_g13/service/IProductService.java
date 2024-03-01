package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.service;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.ProductDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    ProductDTO addProduct(ProductDTO productDTO);
    List<ProductDTO> getProducts();
    Optional<Product> getProductById(Integer id);
}
