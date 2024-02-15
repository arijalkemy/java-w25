package ejer.linktracker.DTO.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LinkDTO {
    Integer id;
    String url;
    Integer contador;
    String contrasena;
    Boolean esValido;
}
