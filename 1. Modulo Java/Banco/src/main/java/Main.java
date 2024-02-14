import java.util.Base64;

public class Main {
    public static void main(String[] args) {

        Basic basico = new Basic();
        Ejecutivos ejecutivo = new Ejecutivos();
        Cobradores cobrador = new Cobradores();

        basico.consultarSaldo();
        basico.pagarServicio("agua");
        basico.retirarEfectivo(2121);

        ejecutivo.realizarDeposito(2121);
        ejecutivo.realizarTransferencia(1212);

        cobrador.consultarSaldo();
        cobrador.retirarEfectivo(500);
    }
}
