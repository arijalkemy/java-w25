package Ejercicio1;

public class Ejecutivo extends Cliente {

    private void hacerTransferencia() {
        Transferencia transferencia = new Transferencia();

        System.out.println("Realizando transferencia...");
        transferencia.transaccionOk();
    }

    private void realizarDeposito() {
        Deposito deposito = new Deposito();

        System.out.println("Realizando deposito...");
        deposito.transaccionOk();
    }
}
