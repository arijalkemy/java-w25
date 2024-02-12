package me.davidlake.proyectodeportistas.dto.responsedto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

@JsonInclude(JsonInclude.Include.NON_NULL)

public class DeporteDTO {
    private String nombre;
    private Integer nivel;
    private String mensaje;
}
