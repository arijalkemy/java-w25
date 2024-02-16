package com.example.youtuber.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GenericResponseDTO {
    int status;
    String message;
    String description;

    public GenericResponseDTO(int status, String message){
        this.status = status;
        this.message = message;
    }
}
