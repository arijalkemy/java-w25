package com.example.bootcampsprint1g6.util.validator;

import com.example.bootcampsprint1g6.dto.request.PostPromoRequestDTO;
import com.example.bootcampsprint1g6.dto.request.PostRequestDTO;
import com.example.bootcampsprint1g6.util.DateFormatter;

import java.time.LocalDate;

public class PostValidator {
    public static boolean validateRequestDTO (PostRequestDTO request){
        return request.getUserId() != null &&
                request.getCategory() != null &&
                request.getDate() != null &&
                (DateFormatter.parseDateString(request.getDate()).isBefore(LocalDate.now()) ||
                 DateFormatter.parseDateString(request.getDate()).isEqual(LocalDate.now()) ) &&
                request.getPrice() != null &&
                ProductValidator.validateProductDTO(request.getProduct());
    }

    public static boolean validateRequestDTO (PostPromoRequestDTO request){
        return request.getUserId() != null &&
                request.getCategory() != null &&
                request.getDate() != null &&
                (DateFormatter.parseDateString(request.getDate()).isBefore(LocalDate.now()) ||
                        DateFormatter.parseDateString(request.getDate()).isEqual(LocalDate.now()) ) &&
                request.getPrice() != null &&
                ProductValidator.validateProductDTO(request.getProduct()) &&
                request.getDiscount() != null &&
                request.getDiscount() >= 0 && request.getDiscount() <= 1;
    }
}
