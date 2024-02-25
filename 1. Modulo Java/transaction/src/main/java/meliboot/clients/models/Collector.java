package meliboot.clients.models;

import meliboot.transactions.EnumTransactionType;
import meliboot.clients.Client;
import meliboot.transactions.interfaces.ITransaction;
import meliboot.transactions.interfaces.ICanBalanceQuery;
import meliboot.transactions.interfaces.ICanWithdrawCash;
import meliboot.transactions.interfaces.ITransactionFactory;

public class Collector extends Client implements ICanWithdrawCash, ICanBalanceQuery {
    public Collector(ITransactionFactory transactionFactory) {
        super(transactionFactory);
    }

    @Override
    public ITransaction toBalanceQuery() {
        return this.transactionFactory.createTransaction(EnumTransactionType.BALANCE_QUERY);
    }

    @Override
    public ITransaction toWithdrawCash() {
        return this.transactionFactory.createTransaction(EnumTransactionType.CASH_WITHDRAWAL);
    }
}
