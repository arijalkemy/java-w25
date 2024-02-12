package integracion.p1.agencia.base;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class Client {
    private int dni;
    private String nombre;
    private String telefono;
}
