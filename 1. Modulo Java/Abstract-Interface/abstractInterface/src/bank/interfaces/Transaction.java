package bank.interfaces;

public interface Transaction {

    void transactionOk(String transactionType);
    void transactionNotOk(String transactionType);
}
