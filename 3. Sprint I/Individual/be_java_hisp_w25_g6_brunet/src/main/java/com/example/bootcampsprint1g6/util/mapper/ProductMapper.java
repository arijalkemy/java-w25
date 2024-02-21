package com.example.bootcampsprint1g6.util.mapper;

import com.example.bootcampsprint1g6.dto.ProductDTO;
import com.example.bootcampsprint1g6.entity.Product;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.stream.Collectors;


@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductMapper {
    public static ProductDTO getInstance(Product product) {
        ProductDTO dto = ProductDTO.builder()
                .productId(product.getProductId())
                .productName(product.getProductName())
                .type(product.getType())
                .brand(product.getBrand())
                .color(product.getColor())
                .notes(product.getNotes())
                .build();
        return dto;
    }

    public static List<ProductDTO> getInstances(List<Product> personas) {
        return personas.stream().map(ProductMapper::getInstance).collect(Collectors.toList());
    }

    public static Product getEntityInstance(ProductDTO dto) {
        return new Product(dto.getProductId(), dto.getProductName(), dto.getType(), dto.getBrand(), dto.getColor(), dto.getNotes());
    }

}
