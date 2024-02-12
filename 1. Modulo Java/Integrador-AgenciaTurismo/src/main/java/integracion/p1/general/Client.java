package integracion.p1.general;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Client {
    private int dni;
    private String name;
    private String apellido;
}
