package bootcamp.excepcionesp1vivo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BlogDTO {

    private String titulo;
    private String autor;
    private String fechaDePublicacion;

}
