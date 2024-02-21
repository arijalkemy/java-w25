package org.example.exercise1;

import java.util.List;

public class Basic extends Client {
    public Basic() {
        super(List.of(new BalanceCheck(), new CashWithdrawal(), new ServicePayout()));
    }
}
