package meli.com.co.qatesters.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateCaseDto {
    @NotNull(message = "La descripción es requerida")
    @NotBlank(message = "La descripción no puede ser vacía")
    private String description;
    @NotNull(message = "Tested es requerido es requerida")
    private Boolean tested;
    @NotNull(message = "Passed es requerido es requerida")
    private Boolean passed;
    @NotNull(message = "Número de intentos es requerido")
    private Integer numberOfTries;
    private LocalDate lastUpdate = LocalDate.now();

}
