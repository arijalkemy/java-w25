package main;

public class PagoServicios implements ITransaccion{

    @Override
    public void transaccionNoOk() {
        esperar(3);
        System.out.println("Esta acción no esta disponible en el momento");
    }

    @Override
    public void transaccionOk(Cliente cliente) {
        System.out.println("Realizando pago...");
        esperar(3);
        System.out.println("Su pago fue exitoso");
        esperar(2);
        System.out.println("Su nuevo salgo es: " + (cliente.getSaldo() - 150000));
    }

    private static void esperar(int segundos){
        try {
            Thread.sleep(segundos * 1000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
