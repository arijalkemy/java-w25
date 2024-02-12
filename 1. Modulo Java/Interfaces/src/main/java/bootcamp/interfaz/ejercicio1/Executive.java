package bootcamp.interfaz.ejercicio1;

public class Executive implements IExecutive {
    @Override
    public void transactionOk() {
        System.out.println("executive transaction  OK" );
    }

    @Override
    public void transactionNoOk() {
        System.out.println("executive transaction error" );
    }

    public void deposit(){
        System.out.println(" Deposit done " );
    }
    public void transfer(){
        System.out.println(" Transfer Done " );
    }
}
