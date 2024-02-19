public class Ejecutivo extends Cliente {
    public Ejecutivo(String nombre, String tipoCliente) {
        super(nombre, tipoCliente);
    }

    @Override
    public void movimiento(String movimiento) {
        if(movimiento.equals("depositos") || movimiento.equalsIgnoreCase("transferencias")){
            super.transaccionOk(movimiento);
        }else {
            super.transaccionNoOk(movimiento);
        }
    }
}
