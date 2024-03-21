package com.example.deportistas.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DeporteDTO {
    String nombre;
    private int nivel;

}
