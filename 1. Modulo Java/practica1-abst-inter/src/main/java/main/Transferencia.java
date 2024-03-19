package main;

public class Transferencia implements ITransaccion{

    @Override
    public void transaccionNoOk() {
        esperar(3);
        System.out.println("Esta acción no esta disponible en el momento");
    }

    @Override
    public void transaccionOk(Cliente cliente) {
        System.out.println("Realizando transferencia...");
        esperar(2);
        System.out.println("Se tranfirieron 100000 a la cuenta 378-134575-39 de manera exitosa");
        esperar(1);
        System.out.println("Su nuevo saldo es de: " + (cliente.getSaldo() - 100000));
    }

    private static void esperar(int segundos){
        try {
            Thread.sleep(segundos * 1000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
