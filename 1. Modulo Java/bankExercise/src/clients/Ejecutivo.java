package clients;

import transactions.Deposit;

public class Ejecutivo extends Client{

    public void Deposit(){
        Deposit deposit = new Deposit();
        deposit.transactionOk();
    }

    public void Transfer(){
        System.out.println("Transferencia realizada");
    }
}
