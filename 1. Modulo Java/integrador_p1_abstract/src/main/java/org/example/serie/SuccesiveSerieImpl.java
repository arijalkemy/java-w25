package org.example.serie;

public class SuccesiveSerieImpl extends SuccesiveSerie<Number>
{
    public Number nextValue() {
        int valueToSum;
        if(this.initialValue.intValue() == 1 || this.initialValue.intValue() == 2) {
            valueToSum = 2;
        } else if (this.initialValue.intValue() == 3) {
            valueToSum = 3;
        } else {
            throw new IllegalArgumentException("The initial value must be 1, 2 or 3");
        }
        this.currentValue = this.currentValue.doubleValue() + valueToSum;
        return this.currentValue;
    }
}
