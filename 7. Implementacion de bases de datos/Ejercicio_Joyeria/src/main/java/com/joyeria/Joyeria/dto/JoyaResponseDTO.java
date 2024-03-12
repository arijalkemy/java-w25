package com.joyeria.Joyeria.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
public class JoyaResponseDTO {
    Long id;
    String msg;
    String nombre;
    String material;
    String particularidad;
    Double peso;
    Boolean posee_piedra;
    Boolean ventaONo;

    public JoyaResponseDTO(Long id, String msg) {
        this.id = id;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg + this.id;
    }

    public JoyaResponseDTO(Long id, String msg, String nombre, String material,
                           String particularidad, Double peso, Boolean posee_piedra, Boolean ventaONo) {
        this.id = id;
        this.msg = msg;
        this.nombre = nombre;
        this.material = material;
        this.particularidad = particularidad;
        this.peso = peso;
        this.posee_piedra = posee_piedra;
        this.ventaONo = ventaONo;
    }
}
