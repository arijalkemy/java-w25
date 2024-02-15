public abstract class NumericSeries<T extends Number> {
    protected T currentValue;
    protected T increment;

    public NumericSeries(T currentValue, T increment) {
        this.currentValue = currentValue;
        this.increment = increment;
    }

    public abstract T genNextValue();

    public void reset() {
        this.currentValue = increment;
    }

    public void setInitialValue(T newValue) {
    this.currentValue = newValue;
    }
}
