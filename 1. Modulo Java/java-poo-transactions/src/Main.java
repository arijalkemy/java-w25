public class Main {
    public static void main(String[] args) {
        Basic basic = new Basic();
        basic.realizarConsultaSaldo();
        Ejecutivo ejecutivo = new Ejecutivo();
        ejecutivo.realizarDeposito();
        Cobrador cobrador = new Cobrador();
        cobrador.realizarConsultaSaldo();
    }
}