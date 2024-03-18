package com.bootcamp.deportistas.dto;

import com.bootcamp.deportistas.entity.Deporte;
import lombok.Data;

@Data
public class DeporteDTO {
    private String nombre;
    private String nivel;
    public DeporteDTO(Deporte deporte){
        this.nombre = deporte.getNombre();;
        this.nivel = deporte.getNivel();
    }
}
