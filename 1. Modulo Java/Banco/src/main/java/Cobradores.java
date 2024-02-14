import interfaces.ConsultaSaldo;
import interfaces.RetiroEfectivo;

public class Cobradores implements RetiroEfectivo, ConsultaSaldo {
    public Cobradores() {
    }

    @Override
    public void consultarSaldo() {
        System.out.println("consultando saldo...");
        System.out.println(transaccionOk("Consulta saldo"));
    }

    @Override
    public void retirarEfectivo(double monto) {
        System.out.println("retirando efectivo...");
        System.out.println(transaccionOk("retiro efectivo"));
    }

    @Override
    public String transaccionOk(String tipo) {
        return tipo+" aceptada";
    }

    @Override
    public String transaccionNoOk(String tipo) {
        return tipo+" rechazada";
    }
}
