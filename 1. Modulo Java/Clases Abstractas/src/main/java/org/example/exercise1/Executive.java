package org.example.exercise1;

import java.util.List;

public class Executive extends Client{
    public Executive() {
        super(List.of(new Deposit(), new Transfer()));
    }
}
