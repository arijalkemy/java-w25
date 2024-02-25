package meliboot.transactions.interfaces;

import meliboot.transactions.EnumTransactionType;

public interface ITransactionFactory {
    public ITransaction createTransaction(EnumTransactionType transactionType);
}
