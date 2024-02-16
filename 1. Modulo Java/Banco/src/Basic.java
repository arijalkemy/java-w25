public class Basic extends Cliente{
    public Basic(String nombre, String tipoCliente) {
        super(nombre, tipoCliente);
    }

    @Override
    public void movimiento(String movimiento) {
        if(movimiento.equals("consulta") || movimiento.equalsIgnoreCase("pago")
            || movimiento.equalsIgnoreCase("retiro")){
            super.transaccionOk(movimiento);
        }else {
            super.transaccionNoOk(movimiento);
        }
    }
}
