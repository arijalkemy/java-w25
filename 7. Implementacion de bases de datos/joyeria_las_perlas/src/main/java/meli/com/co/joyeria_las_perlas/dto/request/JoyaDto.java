package meli.com.co.joyeria_las_perlas.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class JoyaDto{
        @NotNull(message = "El nombre es obligatorio")
        @NotBlank(message = "El nombre no puede estar vacío")
        String nombre;
        @NotNull(message = "El material es obligatorio")
        @NotBlank(message = "El material no puede estar vacío")
        String material;
        @Min(value = 0, message = "El peso no puede ser inferior a 0")
        Float peso;
        String particularidad;
        Boolean posee_piedra;
        Boolean ventaONo;
}
