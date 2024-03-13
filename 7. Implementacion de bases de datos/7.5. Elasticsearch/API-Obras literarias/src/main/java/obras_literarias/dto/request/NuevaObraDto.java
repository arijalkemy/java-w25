package obras_literarias.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NuevaObraDto {
    @NotBlank(message = "El nombre no puede estar vacío")
    String nombre;
    String autor;
    @Positive(message = "Las páginas deben ser un número positivo")
    Integer paginas;
    String editorial;
    @Pattern(regexp = "^[0-9]{4}$", message = "El año debe tener 4 dígitos")
    Integer annoPublicacion;
}