package meliboot.clients;

import meliboot.transactions.interfaces.ITransactionFactory;

public abstract class  Client {

    protected ITransactionFactory transactionFactory;
    public Client(ITransactionFactory transactionFactory){
        this.transactionFactory = transactionFactory;
    }
}
