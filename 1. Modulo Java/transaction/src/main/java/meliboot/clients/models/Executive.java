package meliboot.clients.models;

import meliboot.clients.Client;
import meliboot.transactions.EnumTransactionType;
import meliboot.transactions.interfaces.ITransaction;
import meliboot.transactions.interfaces.ICanDeposit;
import meliboot.transactions.interfaces.ICanTransfer;
import meliboot.transactions.interfaces.ITransactionFactory;

public class Executive  extends Client implements ICanDeposit, ICanTransfer {

    public Executive(ITransactionFactory transactionFactory){
        super(transactionFactory);
    }
    public ITransaction toDeposite(){
        return this.transactionFactory.createTransaction(EnumTransactionType.DEPOSIT);
    }

    public ITransaction  toTransfer(){
        return this.transactionFactory.createTransaction(EnumTransactionType.TRANSFER);
    }
}
