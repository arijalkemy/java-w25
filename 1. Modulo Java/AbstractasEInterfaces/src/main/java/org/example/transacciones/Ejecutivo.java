package org.example.transacciones;


public class Ejecutivo implements Deposito, Transferencia{

    @Override
    public String Depositar(int i) {
        if (i == 1){
            return "Depositando\n...\n...\n" + transaccionOk();
        }
        return "Depositando\n...\n...\n" + transaccionNoOk();
    }

    @Override
    public String transaccionOk() {
        return "Transaccion realizada con exito";
    }

    @Override
    public String transaccionNoOk() {
        return "La transaccion no pudo ser realizada";
    }

    @Override
    public String transferir(int i) {
        if (i == 1){
            return "Transfiriendo\n...\n...\n" + transaccionOk();
        }
        return "Transfiriendo\n...\n...\n" + transaccionNoOk();
    }
}
