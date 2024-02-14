package blog.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Data
public class EntradaBlogDTO {
    Integer id;
    String titulo;
    String autor;
    String fechaPublicacion;
}
