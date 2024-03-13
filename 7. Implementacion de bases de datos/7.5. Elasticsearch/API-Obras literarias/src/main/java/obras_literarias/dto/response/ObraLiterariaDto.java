package obras_literarias.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ObraLiterariaDto {
    String id;
    String nombre;
    String autor;
    Integer paginas;
    String editorial;
    Integer annoPublicacion;

    public ObraLiterariaDto(String nombre, String autor, Integer paginas, String editorial, Integer annoPublicacion) {
        this.nombre = nombre;
        this.autor = autor;
        this.paginas = paginas;
        this.editorial = editorial;
        this.annoPublicacion = annoPublicacion;
    }
}