package bootcamp.elasticsearchgrupal.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ObraLiterariaResponseDTO {

    String id;

    String nombre;

    String autor;

    Integer cantidadDePaginas;

    String editorial;

    Integer anioDePrimeraPublicacion;

}
