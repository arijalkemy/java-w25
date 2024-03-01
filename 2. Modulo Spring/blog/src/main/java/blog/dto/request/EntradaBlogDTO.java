package blog.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EntradaBlogDTO {
    private Integer id;
    private String titulo;
    private String nombreAutor;
    private String fechaDePublicacion;
}
