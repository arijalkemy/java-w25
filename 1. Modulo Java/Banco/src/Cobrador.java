import java.util.Arrays;

public class Cobrador extends Cliente{

    public Cobrador(String nombre, String tipoCliente) {
        super(nombre, tipoCliente);
    }

    @Override
    public void movimiento(String movimiento) {
        if(movimiento.equals("retiro") || movimiento.equalsIgnoreCase("consulta")){
            super.transaccionOk(movimiento);
        }else {
            super.transaccionNoOk(movimiento);
        }
    }
}
