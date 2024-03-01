package com.example.bootcampsprint1g6.util.mapper;

import com.example.bootcampsprint1g6.dto.ProductDTO;
import com.example.bootcampsprint1g6.entity.Product;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;


@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductMapper {
    /**
     * Get an instance of ProductDTO from a Product instance
     * @param product Product instance to initialize a new ProductDTO
     * @return A new ProductDTO instance
     */
    public static ProductDTO getInstance(Product product) {
        return ProductDTO.builder()
                .productId(product.getProductId())
                .productName(product.getProductName())
                .type(product.getType())
                .brand(product.getBrand())
                .color(product.getColor())
                .notes(product.getNotes())
                .build();
    }

    /**
     * Get a Product instance from a ProductDTO instance
     * @param dto ProductDTO to get the Product instance
     * @return A new Product instance
     */
    public static Product getEntityInstance(ProductDTO dto) {
        return new Product(dto.getProductId(), dto.getProductName(), dto.getType(), dto.getBrand(), dto.getColor(), dto.getNotes());
    }

}
