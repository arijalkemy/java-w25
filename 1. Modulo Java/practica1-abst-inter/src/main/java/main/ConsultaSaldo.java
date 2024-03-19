package main;

public class ConsultaSaldo implements ITransaccion{

    @Override
    public void transaccionNoOk() {
        esperar(3);
        System.out.println("Esta acción no esta disponible en el momento");
    }

    @Override
    public void transaccionOk(Cliente cliente) {
        System.out.println("Realizando consulta...");
        esperar(2);
        System.out.println("Su saldo disponible: " + cliente.getSaldo());
    }
    private static void esperar(int segundos){
        try {
            Thread.sleep(segundos * 1000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
