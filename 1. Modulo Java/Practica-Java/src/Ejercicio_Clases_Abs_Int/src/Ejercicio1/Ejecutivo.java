package Ejercicio_Clases_Abs_Int.src.Ejercicio1;

public class Ejecutivo extends Cliente {
    private Deposito deposito;
    private Transferencia transferencia;

    public Ejecutivo(String nombre, Deposito deposito, Transferencia transferencia) {
        super(nombre);
        this.deposito = deposito;
        this.transferencia = transferencia;
    }

    private void hacerTransferencia() {
        transferencia.transaccionOk();
    }

    private void realizarDeposito() {
        deposito.transaccionOk();
    }
}
