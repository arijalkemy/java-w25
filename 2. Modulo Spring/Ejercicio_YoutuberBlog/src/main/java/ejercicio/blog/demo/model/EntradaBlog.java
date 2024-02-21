package ejercicio.blog.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EntradaBlog {
    private Integer id;
    private String titulo;
    private String nombreAutor;
    private String fechaPub;
}
