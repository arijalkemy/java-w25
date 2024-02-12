package org.example.exercise1;

import java.util.List;

public class Collector extends Client{
    public Collector() {
        super(List.of(new CashWithdrawal(), new BalanceCheck()));
    }
}
