package bootcamp.elasticsearchgrupal.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "obrasliterarias")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ObraLiteraria {

    @Id
    String id;

    String nombre;

    String autor;

    Integer cantidadDePaginas;

    String editorial;

    Integer anioDePrimeraPublicacion;

}
