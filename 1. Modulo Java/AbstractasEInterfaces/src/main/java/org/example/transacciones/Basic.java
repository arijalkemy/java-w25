package org.example.transacciones;

public class Basic implements ConsultaDeSaldo,PagoDeServicios,RetiroDeEfectivo{
    @Override
    public String consultar(int i) {
        if (i == 1){
            return "Consultando\n...\n...\n" + transaccionOk();
        }
        return "Consultando\n...\n...\n" + transaccionNoOk();
    }

    @Override
    public String pagar(int i) {
        if (i == 1){
            return "Pagando\n...\n...\n" + transaccionOk();
        }
        return "Pagando\n...\n...\n" + transaccionNoOk();
    }

    @Override
    public String Retirar(int i) {
        if (i == 1){
            return "Retirando\n...\n...\n" + transaccionOk();
        }
        return "Retirando\n...\n...\n" + transaccionNoOk();
    }

    @Override
    public String transaccionOk() {
        return "Transaccion realizada con exito";
    }

    @Override
    public String transaccionNoOk() {
        return "La transaccion no pudo ser realizada";
    }

}
