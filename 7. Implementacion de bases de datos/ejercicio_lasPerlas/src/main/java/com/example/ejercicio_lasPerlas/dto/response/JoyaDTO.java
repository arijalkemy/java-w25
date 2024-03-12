package com.example.ejercicio_lasPerlas.dto.response;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class JoyaDTO {
    private Long nro_identificatorio;
    private String nombre;
    @Pattern(regexp = "oro|plata|diamante|zafiro", flags = Pattern.Flag.CASE_INSENSITIVE)
    private String material;
    private Integer peso;
    private String particularidad;
    private Boolean posee_piedra;
    private Boolean ventaONo;
}
