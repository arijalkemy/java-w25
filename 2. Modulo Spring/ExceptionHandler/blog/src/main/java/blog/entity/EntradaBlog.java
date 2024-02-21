package blog.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntradaBlog {
    private Integer id;
    private String titulo;
    private String nombreAutor;
    private String fechaDePublicacion;
}
