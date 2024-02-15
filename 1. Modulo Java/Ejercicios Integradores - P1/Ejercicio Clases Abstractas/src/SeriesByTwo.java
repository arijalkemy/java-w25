public class SeriesByTwo extends NumericSeries<Integer>{

    public SeriesByTwo() {
        super(0, 2);
    }
    public SeriesByTwo(Integer initialValue) {
        super(initialValue, 2);
    }

    @Override
    public Integer genNextValue() {
        currentValue += increment;
        return currentValue;
    }
}
