package clients;

import transactions.Payment;

public class Basic extends Client{

    public void payment(){
        Payment payment = new Payment();
        payment.transactionOk();
    }
}
