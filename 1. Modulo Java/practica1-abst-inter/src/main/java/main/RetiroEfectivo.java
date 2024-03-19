package main;

public class RetiroEfectivo implements ITransaccion{

    @Override
    public void transaccionNoOk() {
        esperar(3);
        System.out.println("Esta acción no esta disponible en el momento");
    }

    @Override
    public void transaccionOk(Cliente cliente) {
        System.out.println("Realizando retiro...");
        esperar(3);
        System.out.println("Su retiro por 20000 ha sido exitoso");
        esperar(2);
        System.out.println("Su nuevo saldo es de :" + (cliente.getSaldo() - 20000));
    }

    private static void esperar(int segundos){
        try {
            Thread.sleep(segundos * 1000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
