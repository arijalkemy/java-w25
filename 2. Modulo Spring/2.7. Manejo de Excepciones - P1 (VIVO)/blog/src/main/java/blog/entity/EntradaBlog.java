package blog.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Data
public class EntradaBlog {
    Integer id;
    String titulo;
    String autor;
    LocalDate fechaPublicacion;
}
