package bootcamp.elasticsearchgrupal.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ObraLiterariaRequestDTO {

    String nombre;

    String autor;

    Integer cantidadDePaginas;

    String editorial;

    Integer anioDePrimeraPublicacion;

}
