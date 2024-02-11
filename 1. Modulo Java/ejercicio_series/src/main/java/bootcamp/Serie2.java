package bootcamp;

public class Serie2<T extends Number> extends Serie<T> {

    public Serie2(){
        super();
    }
    @Override
    public T siguienteValor() {
        super.setCantIncrementos(super.getCantIncrementos()+1);
        Double result = super.getValorInicial().doubleValue() + (2 * super.getCantIncrementos());
        return (T) result;
    }


}
