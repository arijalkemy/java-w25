package TipoDeUsuario;

import OpcionesBancarias.Deposito;
import OpcionesBancarias.ITransaccion;
import OpcionesBancarias.Transferencia;

public class Ejecutivo extends Usuario {

    private final ITransaccion realizarDeposito = new Deposito();
    private final ITransaccion transferencia = new Transferencia();

    public Ejecutivo(String nombre, Long idUsuario, Double saldo) {
        super(nombre, idUsuario, saldo);
    }

    @Override
    public <T> void realizarTransaccion(T tipoDeTransaccion) {
        if(tipoDeTransaccion instanceof Deposito) {
            if(generarNumeroAleatorio().equals(1)) realizarDeposito.trasaccionOk();
            else ITransaccion.transaccionNoOk();
        }
        if(tipoDeTransaccion instanceof Transferencia){
            if(generarNumeroAleatorio().equals(1)) transferencia.trasaccionOk();
            else ITransaccion.transaccionNoOk();
        }
        else System.out.println("No puede realizar esta operación");
    }
}

