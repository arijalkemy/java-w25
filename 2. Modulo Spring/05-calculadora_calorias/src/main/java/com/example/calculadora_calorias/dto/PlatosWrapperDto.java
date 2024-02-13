package com.example.calculadora_calorias.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.List;



@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlatosWrapperDto {


    List<String> platos;

}
