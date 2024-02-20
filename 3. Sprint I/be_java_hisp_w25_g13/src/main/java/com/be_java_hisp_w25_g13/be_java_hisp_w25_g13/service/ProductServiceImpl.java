package com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.service;

import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.dto.ProductDTO;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.entity.Product;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.exception.NotFoundException;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.repository.IProductRepository;
import com.be_java_hisp_w25_g13.be_java_hisp_w25_g13.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    IProductRepository productRepository;
    @Override
    public ProductDTO addProduct(ProductDTO productDTO) {
        Product product= Mapper.mapProductDtoToProduct(productDTO);

        productRepository.addProduct(product);

        return productDTO;
    }

    @Override
    public List<ProductDTO> getProducts() {
        return productRepository.getAll().stream().map(Mapper::mapProductToProductDto).collect(Collectors.toList());
    }

    @Override
    public Optional<Product> getProductById(Integer id) {
        Optional<Product> product= productRepository.getProductById(id);

        return product;
    }
}
