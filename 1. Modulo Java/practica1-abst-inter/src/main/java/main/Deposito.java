package main;

public class Deposito implements ITransaccion{

    @Override
    public void transaccionNoOk() {
        esperar(3);
        System.out.println("Esta acción no esta disponible en el momento");
    }

    @Override
    public void transaccionOk(Cliente cliente) {
        System.out.println("Realizando deposito...");
        esperar(3);
        System.out.println("Su deposito a la cuenta " + cliente.getNumeroCuenta() + " fue exitoso");
        esperar(1);
        System.out.println("Su nuevo saldo es de: " + (cliente.getSaldo() + 500000));
    }

    private static void esperar(int segundos){
        try {
            Thread.sleep(segundos * 1000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
