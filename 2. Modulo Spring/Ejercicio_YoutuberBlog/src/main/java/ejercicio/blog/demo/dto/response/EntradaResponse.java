package ejercicio.blog.demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EntradaResponse {
    private String mensaje;
    private Integer id;

    @Override
    public String toString() {
        return this.mensaje + " " + this.id;
    }
}
