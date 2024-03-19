package main;

import java.util.Random;

public class Cobrador extends Cliente{
    public Cobrador(String name, String dni, int saldo, String numeroCuenta) {
        super(name, dni, saldo, numeroCuenta);
    }

    @Override
    public void consultarSaldo() {
        System.out.println("Esta acción no esta disponible para su perfil");
    }

    @Override
    public void pagarServicios() {
        System.out.println("Esta acción no esta disponible para su perfil");
    }

    @Override
    public void retirarEfectivo() {
        RetiroEfectivo retiroEfectivo = new RetiroEfectivo();
        transaccionOkOrNoOK(retiroEfectivo);
    }

    @Override
    public void transferir() {
        Transferencia transferencia = new Transferencia();
        transaccionOkOrNoOK(transferencia);
    }

    @Override
    public void depositar() {
        System.out.println("Esta acción no esta disponible para su perfil");
    }

    private  <T extends ITransaccion> void transaccionOkOrNoOK(T transaccion){
        Random ran = new Random();
        switch (ran.nextInt(2) + 1){
            case 1:{
                transaccion.transaccionOk(this);
                break;
            }
            case 2:{
                transaccion.transaccionNoOk();
                break;
            }
        }
    }
}
