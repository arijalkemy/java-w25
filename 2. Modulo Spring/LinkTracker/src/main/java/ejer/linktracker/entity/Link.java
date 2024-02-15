package ejer.linktracker.entity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Link {
    Integer id;
    String url;
    Integer contador;
    String contrasena;
    Boolean esValido;

    public void aumentarContador() {
        this.contador ++;
    }
}
