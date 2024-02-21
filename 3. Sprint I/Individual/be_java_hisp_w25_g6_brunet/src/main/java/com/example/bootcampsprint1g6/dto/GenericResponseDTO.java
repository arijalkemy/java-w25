package com.example.bootcampsprint1g6.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GenericResponseDTO {

    private Integer status;
    private String message;
}
