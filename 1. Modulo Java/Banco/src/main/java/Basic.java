import interfaces.ConsultaSaldo;
import interfaces.PagoServicio;
import interfaces.RetiroEfectivo;

public class Basic  implements ConsultaSaldo, PagoServicio, RetiroEfectivo {
    public Basic() {
    }

    @Override
    public void consultarSaldo() {
        System.out.println("Consultando Saldo...");
        System.out.println(transaccionOk("Consulta saldo"));
    }

    @Override
    public void pagarServicio(String servicio) {
        System.out.println("pagando servicio...");
        System.out.println(transaccionOk("pago servicio"));

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
        return tipo+" denegada";
    }
}
