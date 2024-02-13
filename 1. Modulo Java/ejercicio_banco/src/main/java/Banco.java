import model.Basic;
import model.Cobrador;
import model.Ejecutivo;

public class Banco {
    public static void main(String[] args) {

        Cobrador cobrador = new Cobrador();
        Basic basic = new Basic();
        Ejecutivo ejecutivo = new Ejecutivo();

        System.out.println("----- Probando cobrador -----");
        cobrador.consultarSaldo();
        cobrador.retirarEfectivo(21000.21);
        System.out.println("----- Probando basic -----");
        basic.pagarServicios("Luz");
        basic.consultarSaldo();
        basic.retirarEfectivo(200.11);
        System.out.println("----- Probando ejecutivo -----");
        ejecutivo.realizarDeposito();
        ejecutivo.realizarTransferencia();
    }

}
