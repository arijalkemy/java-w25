package com.example.bootcampsprint1g6.util.validator;

import com.example.bootcampsprint1g6.dto.request.PostRequestDTO;
import com.example.bootcampsprint1g6.util.DateFormatter;

import java.time.LocalDate;

public class PostValidator {
    public static boolean validateRequestDTO (PostRequestDTO request){
        return request.getUserId() != null &&
                request.getCategory() != null &&
                (DateFormatter.parseDateString(request.getDate()).isBefore(LocalDate.now()) ||
                 DateFormatter.parseDateString(request.getDate()).isEqual(LocalDate.now()) ) &&
                request.getPrice() != null &&
                ProductValidator.validateProductDTO(request.getProduct());
    }
}
