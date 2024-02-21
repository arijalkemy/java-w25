package org.example.exercise1;

public class CashWithdrawal implements ITransaction{


    @Override
    public void transaccionOk() {
        System.out.println("Se ha retirado efectivo con exito!");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se ha podido retirar el efectivo!");
    }


}
