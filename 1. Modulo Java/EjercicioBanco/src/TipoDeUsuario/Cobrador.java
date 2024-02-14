package TipoDeUsuario;

import OpcionesBancarias.ConsultaDeSaldo;
import OpcionesBancarias.ITransaccion;
import OpcionesBancarias.RetiroDeEfectivo;

public class Cobrador extends Usuario {

    private final ITransaccion retiroEfectivo = new RetiroDeEfectivo();
    private final ITransaccion consultaSaldo = new ConsultaDeSaldo();

    public Cobrador(String nombre, Long idUsuario, Double saldo) {
        super(nombre, idUsuario, saldo);
    }

    @Override
    public <T> void realizarTransaccion(T tipoDeTransaccion) {
        if(tipoDeTransaccion instanceof ConsultaDeSaldo){
            if(generarNumeroAleatorio().equals(1)) consultaSaldo.trasaccionOk();
            else ITransaccion.transaccionNoOk();
        }
        if(tipoDeTransaccion instanceof RetiroDeEfectivo){
            if(generarNumeroAleatorio().equals(1)) retiroEfectivo.trasaccionOk();
            else ITransaccion.transaccionNoOk();
        }
        else System.out.println("No puede realizar esta operación");
    }
}
