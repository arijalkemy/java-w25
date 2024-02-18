package Ejercicio1;

public class Cobrador extends Cliente {

    public void retirarSaldo() {
        RetiroEnEfectivo retiro = new RetiroEnEfectivo();
        retiro.transaccionOk();
    }

    public void consultarSaldo() {
        ConsultaDeSaldo consulta = new ConsultaDeSaldo();
        consulta.transaccionOk();
    }
}
