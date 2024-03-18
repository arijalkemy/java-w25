package meli.com.co.grupalelastic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObraLiterariaDto {

    String nombre;
    String autor;
    int cantidadPaginas;
    String editorial;
    int anio;

}
