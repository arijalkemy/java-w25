package com.bootcamp.deportistas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
public class Deporte {
    private String nombreDeporte;
    private String nivel;

}
