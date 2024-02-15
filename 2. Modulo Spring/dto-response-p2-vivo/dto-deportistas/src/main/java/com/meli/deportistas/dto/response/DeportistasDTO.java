package com.meli.deportistas.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class DeportistasDTO {
    private String nombreYApellido;
    private String nombreDeporte;
}
