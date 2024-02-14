package bootcamp.excepcionesp1vivo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EntradaBlog {

    private Integer id;
    private String titulo;
    private String autor;
    private String fechaDePublicacion;

}
