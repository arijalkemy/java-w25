package TipoDeUsuario;

import OpcionesBancarias.ConsultaDeSaldo;
import OpcionesBancarias.ITransaccion;
import OpcionesBancarias.PagoDeServicios;
import OpcionesBancarias.RetiroDeEfectivo;

public class Basic extends Usuario {

    private final ITransaccion consultaSaldo = new ConsultaDeSaldo();
    private final ITransaccion pagoServicios = new PagoDeServicios();
    private final ITransaccion retiroEfectivo = new RetiroDeEfectivo();

    public Basic(String nombre, Long idUsuario, Double saldo) {
        super(nombre, idUsuario, saldo);
    }

    @Override
    public <T> void realizarTransaccion(T tipoDeTransaccion) {
        if(tipoDeTransaccion instanceof ConsultaDeSaldo){
            if(generarNumeroAleatorio().equals(1)) consultaSaldo.trasaccionOk();
            else ITransaccion.transaccionNoOk();
        }
        else if(tipoDeTransaccion instanceof PagoDeServicios){
            if(generarNumeroAleatorio().equals(1)) pagoServicios.trasaccionOk();
            else ITransaccion.transaccionNoOk();
        }
        else if(tipoDeTransaccion instanceof RetiroDeEfectivo){
            if(generarNumeroAleatorio().equals(1)) retiroEfectivo.trasaccionOk();
            else ITransaccion.transaccionNoOk();
        }
        else System.out.println("No puede realizar esta operación");
    }
}
