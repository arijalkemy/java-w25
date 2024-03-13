package meli.com.co.grupalelastic.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "obras_literarias")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ObraLiteraria {

    @Id
    String id;
    String nombre;
    String autor;
    int cantidadPaginas;
    String editorial;
    int anio;

    public ObraLiteraria(String nombre, String autor, int cantidadPaginas, String editorial, int anio) {
        this.nombre = nombre;
        this.autor = autor;
        this.cantidadPaginas = cantidadPaginas;
        this.editorial = editorial;
        this.anio = anio;
    }
}
