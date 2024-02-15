public class SeriesByThree extends NumericSeries<Integer>{
    public SeriesByThree() {
        super(0, 3);
    }

    public SeriesByThree(Integer initialValue) {
        super(initialValue, 3);
    }

    @Override
    public Integer genNextValue() {
        currentValue += increment;
        return currentValue;
    }
}
