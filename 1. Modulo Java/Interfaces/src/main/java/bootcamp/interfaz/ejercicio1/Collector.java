package bootcamp.interfaz.ejercicio1;

public class Collector implements ICollector {
    @Override
    public void transactionOk() {
        System.out.println(" Collector transactioj OK ");
    }

    @Override
    public void transactionNoOk() {
        System.out.println(" Collector transa ");
    }

    public void collectFee(){
        System.out.println(" Fee collected 300 " );
    }

    public void checkBalance(){
        System.out.println(" Collector Banlance 50000 " );
    }
}
