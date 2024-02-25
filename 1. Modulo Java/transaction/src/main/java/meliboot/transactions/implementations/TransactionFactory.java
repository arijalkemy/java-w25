package meliboot.transactions.implementations;

import meliboot.Transfer;
import meliboot.transactions.EnumTransactionType;
import meliboot.transactions.interfaces.ITransaction;
import meliboot.transactions.interfaces.ITransactionFactory;

public class TransactionFactory  implements ITransactionFactory {
    @Override
    public ITransaction createTransaction(EnumTransactionType transactionType) {
        return switch (transactionType){
            case DEPOSIT -> new Deposit();
            case TRANSFER  -> new Transfer();
            case CASH_WITHDRAWAL -> new CashWithdrawal();
            case BALANCE_QUERY -> new BalanceQuery();
            case PAID_FOR_SERVICES  -> new PaidForServices();
        };
    }
}
