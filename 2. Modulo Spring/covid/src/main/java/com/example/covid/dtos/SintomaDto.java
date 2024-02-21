package com.example.covid.dtos;

import com.example.covid.models.GravedadEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SintomaDto {
    private GravedadEnum gravedad;
}
