package org.clase06_02_24.ejercicio_series;

public class SerialClass1 extends Prototype <Number> {
    int memoValue;
    @Override
    public Integer followingValue() {
        return memoValue += 2;
    }

    @Override
    public void resetValue() {
        memoValue = 0;
    }

    @Override
    public void initialValue(Number number) {
        memoValue = (int) number;
    }
}
