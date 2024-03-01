package com.example.bootcampsprint1g6.util.validator;

import com.example.bootcampsprint1g6.dto.ProductDTO;

public class ProductValidator {

    public static boolean validateProductDTO(ProductDTO productDTO){
        return productDTO.getProductId() != null &&
                productDTO.getProductName() != null &&
                productDTO.getType() != null &&
                productDTO.getNotes() != null &&
                productDTO.getBrand() != null &&
                productDTO.getColor() != null;
    }
}
