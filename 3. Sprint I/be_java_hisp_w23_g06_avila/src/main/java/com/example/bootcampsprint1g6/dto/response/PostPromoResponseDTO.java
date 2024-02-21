package com.example.bootcampsprint1g6.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostPromoResponseDTO extends PostResponseDTO{
    private Optional<Boolean> hasPromo;
    private Optional<Double> discount;
}
