package ejercicio.blog.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EntradaDTO {
    private Integer id;
    private String titulo;
    private String nombreAutor;
    private String fechaPub;
}
