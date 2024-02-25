package meliboot.clients.models;

import meliboot.transactions.EnumTransactionType;
import meliboot.clients.Client;
import meliboot.transactions.interfaces.ITransaction;
import meliboot.transactions.interfaces.ICanBalanceQuery;
import meliboot.transactions.interfaces.ICanPaidForServices;
import meliboot.transactions.interfaces.ICanWithdrawCash;
import meliboot.transactions.interfaces.ITransactionFactory;

public class Basic extends Client implements ICanBalanceQuery, ICanPaidForServices, ICanWithdrawCash {
    public Basic(ITransactionFactory transactionFactory) {
        super(transactionFactory);
    }

    @Override
    public ITransaction toBalanceQuery() {
        return this.transactionFactory.createTransaction(EnumTransactionType.BALANCE_QUERY);
    }

    @Override
    public ITransaction toPayForServices() {
        return this.transactionFactory.createTransaction(EnumTransactionType.PAID_FOR_SERVICES);
    }

    @Override
    public ITransaction toWithdrawCash() {
        return this.transactionFactory.createTransaction(EnumTransactionType.CASH_WITHDRAWAL);
    }
}
