import interfaces.Deposito;
import interfaces.Transferencia;

public class Ejecutivos implements Deposito, Transferencia {
    public Ejecutivos() {
    }

    @Override
    public void realizarDeposito(double monto) {
        System.out.println("realizando deposito...");
        System.out.println(transaccionOk("deposito"));
    }

    @Override
    public String transaccionOk(String tipo) {
        return tipo+" aceptada";
    }

    @Override
    public String transaccionNoOk(String tipo) {
        return tipo+" rechazada";
    }

    @Override
    public void realizarTransferencia(double monto) {
        System.out.println("realizando transferencia...");
        System.out.println(transaccionOk("transferencia"));
    }
}
