package bootcamp.interfaz.ejercicio1;

public class Client implements IBasic {
    @Override
    public void transactionOk() {
        System.out.println(" Client transaction ok " );
    }

    @Override
    public void transactionNoOk() {
        System.out.println(" Cliente transaccion error " );
    }

    public void checkBalance(){
        System.out.println(" client balance 1000" );
    }

    public void withdrawBalance(){
        System.out.println(" client new balance 400 " );
    }

}
