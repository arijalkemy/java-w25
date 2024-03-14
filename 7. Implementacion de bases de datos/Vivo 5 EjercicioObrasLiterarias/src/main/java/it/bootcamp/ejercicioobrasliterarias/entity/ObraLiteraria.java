package it.bootcamp.ejercicioobrasliterarias.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(indexName = "obras")
public class ObraLiteraria {
    @Id
    String id;
    String nombre;
    String autor;
    Integer cantidadPaginas;
    String editorial;
    Integer anyoPrimeraPublicacion;
}
